package com.shenhai.tech.market.project.strategy.zlhq;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shenhai.tech.market.common.utils.*;
import com.shenhai.tech.market.project.cache.ConstantCache;
import com.shenhai.tech.market.project.strategy.entity.*;
import com.shenhai.tech.market.project.strategy.zlhq.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Component
public class HQMarketParser {
    public List<StockQuota> parseStockQuotas(JsonObject response, List<String> fields) {
        List<StockQuota> stockQuotas = new ArrayList<>();
        if (response == null) {
            return stockQuotas;
        }
        JsonArray dataArray = response.getAsJsonArray("data");
        for (JsonElement item : dataArray) {
            JsonArray itemArray = item.getAsJsonArray();
            if (itemArray == null || itemArray.isJsonNull()) {
                continue;
            }
            QHStock qhStock = parseZLQHStock(itemArray, fields);
            if (StringUtils.isNull(qhStock)) {
                continue;
            }
            StockQuota stockQuota = MarketBuilds.castStockQuota(qhStock);
            if (!StockUtils.isSH(stockQuota.getCode()) && !StockUtils.isSZ(stockQuota.getCode())) {
                continue;
            }
            stockQuotas.add(stockQuota);
        }
        return stockQuotas;
    }

    public List<Stock> parseStocks(JsonObject response, List<String> fields) {
        List<Stock> stocks = new ArrayList<>();
        if (response == null) {
            return stocks;
        }
        JsonArray dataArray = response.getAsJsonArray("data");
        for (JsonElement item : dataArray) {
            JsonArray itemArray = item.getAsJsonArray();
            if (itemArray == null || itemArray.isJsonNull()) {
                continue;
            }
            QHStock qhStock = parseZLQHStock(itemArray, fields);
            if (StringUtils.isNull(qhStock)) {
                continue;
            }
            Stock stock = MarketBuilds.castStock(qhStock, ConstantCache.getHolidays());
            if (!stock.getIsSH() && !stock.getIsSZ()) {
                continue;
            }
            stocks.add(stock);
        }
        return stocks;
    }

    private QHStock parseZLQHStock(JsonArray array, List<String> fields) {
        try {
            Map<String, Object> beanMap = new HashMap<>();
            for (int i = 0; i < array.size(); ++i) {
                String key = fields.get(i);
                Object value = FieldsParser.getValue(array.get(i), key);
                beanMap.put(key, value);
            }
            return BeanUtil.mapToObj(beanMap, QHStock.class);
        } catch (Exception e) {
            log.error("stock(最新行情)数据解析失败", e);
        }
        return null;
    }

    public List<StockCode> parseAllStockCodes(JsonObject result) {
        List<StockCode> stockCodes = new ArrayList<>();
        if (result == null) {
            return stockCodes;
        }
        JsonArray dataArray = result.getAsJsonArray("data");
        if(dataArray == null) {
            return stockCodes;
        }
        for (JsonElement item : dataArray) {
            if(item == null) {
                continue;
            }
            JsonArray itemArray = item.getAsJsonArray();
            if (itemArray.isJsonNull()) {
                continue;
            }
            String symbol = itemArray.get(0).getAsString();
            String stockName = itemArray.get(1).getAsString();
            String stockSpell = itemArray.get(2).getAsString();
            if (StringUtils.isEmpty(symbol) || StringUtils.isEmpty(stockName)) {
                continue;
            }
            StockCode stockCode = new StockCode();
            stockCode.setStockCode(StockUtils.symbolToCode(symbol));
            stockCode.setStockBlock(StockUtils.symbolToBlock(symbol));
            stockCode.setStockName(stockName);
            stockCode.setStockJaneSpell(stockSpell);
            stockCodes.add(stockCode);
        }
        return stockCodes;
    }

    public Map<String, List<RTKLine>> parseMinuteRealTimeKLines(JsonObject response, List<String> fields) {
        Map<String, List<RTKLine>> stringListMap = new HashMap<>();
        if (response == null) {
            return stringListMap;
        }

        JsonArray dataArray = response.getAsJsonArray("data");
        if(dataArray == null) {
            return stringListMap;
        }
        for (JsonElement item : dataArray) {
            if (item == null) {
                continue;
            }
            JsonArray itemArray = item.getAsJsonArray();
            if (itemArray.isJsonNull()) {
                continue;
            }
            QHStock zlqhStock = parseZLQHStock(itemArray, fields);
            if (StringUtils.isNull(zlqhStock)) {
                continue;
            }
            List<RTKLine> rtkLines = MarketBuilds.castRTKLineVOS(zlqhStock);
            if(rtkLines != null) {
                String code = StockUtils.symbolToCode(zlqhStock.getSymbol());
                stringListMap.put(code, rtkLines);
            }
        }
        return stringListMap;
    }

    public List<Dividend> parseDividends(JsonObject response, boolean hasSymbol) {
        if (response == null) {
            return new ArrayList<>();
        }
        JsonArray dataArray = response.getAsJsonArray("data");

        Map<String, Dividend> dividendMap = new HashMap<>();
        for (JsonElement item : dataArray) {
            JsonArray itemArray = item.getAsJsonArray();
            if (itemArray.isJsonNull()) {
                continue;
            }
            HQDividend zlhqDividend = parseDividend(hasSymbol, itemArray);
            Dividend dividend = HQDividend.castDividend(ConstantCache.getHolidays(), zlhqDividend);
            if(dividend.getAnnDate() == null || dividend.getDividendDate() == null) {
                continue;
            }
            if(BigDecimalUtil.leeqZero(dividend.getSend()) && BigDecimalUtil.leeqZero(dividend.getGiveAway()) && BigDecimalUtil.leeqZero(dividend.getIncrease())) {
                continue;
            }
            dividendMap.put(dividend.getUniqueId(), dividend);
        }
        return new ArrayList<>(dividendMap.values());
    }

    private HQDividend parseDividend(boolean hasSymbol, JsonArray itemArray) {
        HQDividend hqDividend = new HQDividend();
        String symbol = null;
        String dateofannouncement;
        String exdividenddate;
        BigDecimal pretaxdividend;
        BigDecimal aftertaxdividend;
        BigDecimal pretaxdividendbh;
        BigDecimal aftertaxdividendbh;
        BigDecimal sharegivingratio;
        BigDecimal transferproportion;
        BigDecimal allotmentratio;
        BigDecimal allotmentprice;
        if (hasSymbol) {
            symbol = itemArray.get(0).getAsString();
            dateofannouncement = itemArray.get(1).getAsString();
            exdividenddate = itemArray.get(2).getAsString();
            pretaxdividend = itemArray.get(3).getAsBigDecimal();
            aftertaxdividend = itemArray.get(4).getAsBigDecimal();
            pretaxdividendbh = itemArray.get(5).getAsBigDecimal();
            aftertaxdividendbh = itemArray.get(6).getAsBigDecimal();
            sharegivingratio = itemArray.get(7).getAsBigDecimal();
            transferproportion = itemArray.get(8).getAsBigDecimal();
            allotmentratio = itemArray.get(9).getAsBigDecimal();
            allotmentprice = itemArray.get(10).getAsBigDecimal();
        } else {
            dateofannouncement = itemArray.get(0).getAsString();
            exdividenddate = itemArray.get(1).getAsString();
            pretaxdividend = itemArray.get(2).getAsBigDecimal();
            aftertaxdividend = itemArray.get(3).getAsBigDecimal();
            pretaxdividendbh = itemArray.get(4).getAsBigDecimal();
            aftertaxdividendbh = itemArray.get(5).getAsBigDecimal();
            sharegivingratio = itemArray.get(6).getAsBigDecimal();
            transferproportion = itemArray.get(7).getAsBigDecimal();
            allotmentratio = itemArray.get(8).getAsBigDecimal();
            allotmentprice = itemArray.get(9).getAsBigDecimal();
        }

        hqDividend.setSymbol(symbol);
        hqDividend.setDateofannouncement(dateofannouncement);
        hqDividend.setExdividenddate(exdividenddate);
        hqDividend.setPretaxdividend(BigDecimalUtil.to2Scale(pretaxdividend));
        hqDividend.setAftertaxdividend(BigDecimalUtil.to2Scale(aftertaxdividend));
        hqDividend.setPretaxdividendbh(BigDecimalUtil.to2Scale(pretaxdividendbh));
        hqDividend.setAftertaxdividendbh(BigDecimalUtil.to2Scale(aftertaxdividendbh));
        hqDividend.setSharegivingratio(BigDecimalUtil.to2Scale(sharegivingratio));
        hqDividend.setTransferproportion(BigDecimalUtil.to2Scale(transferproportion));
        hqDividend.setAllotmentratio(BigDecimalUtil.to2Scale(allotmentratio));
        hqDividend.setAllotmentprice(BigDecimalUtil.to2Scale(allotmentprice));
        return hqDividend;
    }
}
