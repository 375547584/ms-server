package com.shenhai.tech.market.project.strategy.tu;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shenhai.tech.market.common.utils.BeanUtil;
import com.shenhai.tech.market.common.utils.BigDecimalUtil;
import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.Dividend;
import com.shenhai.tech.market.project.strategy.zlhq.FieldsParser;
import com.shenhai.tech.market.project.strategy.entity.Suspension;
import com.shenhai.tech.market.project.strategy.entity.DelistStock;
import com.shenhai.tech.market.project.strategy.tu.entity.TuStock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class TuShareMarketParser {

    public List<Suspension> parseSuspensions(JsonObject response, List<String> fields) {

        if (response == null) {
            return null;
        }
        JsonObject data = response.get("data").getAsJsonObject();
        JsonArray dataArray = data.get("items").getAsJsonArray();
        if(dataArray == null) {
            return null;
        }
        List<Suspension> suspensions = null;
        for (JsonElement item : dataArray) {
            JsonArray itemArray = item.getAsJsonArray();
            if (itemArray.isJsonNull()) {
                continue;
            }
            TuStock tuStock = parseTUStock(itemArray, fields);
            if(tuStock == null) {
                continue;
            }
            Suspension suspension = TuStock.castSuspension(tuStock);
            if(suspensions == null) {
                suspensions = new ArrayList<>();
            }
            suspensions.add(suspension);
        }
        return suspensions;
    }


    public List<DelistStock> parseStopStocks(JsonObject response, List<String> fields) {

        if (response == null) {
            return null;
        }
        JsonObject data = response.get("data").getAsJsonObject();
        JsonArray dataArray = data.get("items").getAsJsonArray();
        if(dataArray == null) {
            return null;
        }
        List<DelistStock> delistStocks = null;
        for (JsonElement item : dataArray) {
            JsonArray itemArray = item.getAsJsonArray();
            if (itemArray.isJsonNull()) {
                continue;
            }
            TuStock tuStock = parseTUStock(itemArray, fields);
            if(tuStock == null) {
                continue;
            }

            DelistStock delistStockVO = TuStock.castStopStock(tuStock);

            if(StringUtils.isNotEmpty(delistStockVO.getStockCode())) {
                if(delistStocks == null) {
                    delistStocks = new ArrayList<>();
                }
                delistStocks.add(delistStockVO);
            }
        }
        return delistStocks;
    }

    public List<Dividend> parseDividends(JsonObject response, List<String> fields) {
        if (response == null) {
            return new ArrayList<>();
        }
        JsonObject data = response.get("data").getAsJsonObject();
        JsonArray dataArray = data.get("items").getAsJsonArray();
        if(dataArray == null) {
            return new ArrayList<>();
        }
        Map<String, Dividend> dividendMap = new HashMap<>();
        for (JsonElement item : dataArray) {
            JsonArray itemArray = item.getAsJsonArray();
            if (itemArray.isJsonNull()) {
                continue;
            }
            TuStock tuStock = parseTUStock(itemArray, fields);
            if(tuStock == null) {
                continue;
            }
            Dividend dividend = TuStock.castDividend(tuStock);
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


    private TuStock parseTUStock(JsonArray array, List<String> fields) {
        try {
            Map<String, Object> beanMap = new HashMap<>();
            for (int i = 0; i < array.size(); ++i) {
                String feild = fields.get(i);
                Object value = FieldsParser.getTuValue(array.get(i), feild);
                beanMap.put(feild, value);
            }
            return BeanUtil.mapToObj(beanMap, TuStock.class);
        } catch (Exception e) {
            log.error("挖地兔数据解析失败", e);
        }
        return null;
    }

}
