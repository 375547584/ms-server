package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.constant.Symbols;
import com.shenhai.tech.market.project.strategy.entity.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StockCache {
    private static final ConcurrentMap<String, Stock> allMap = new ConcurrentHashMap<>();
    public static Map<String, Stock> getAllMap() {
        return allMap;
    }

    public static void put(String code, Stock stock) {
        if(StringUtils.isEmpty(code)) {
            return;
        }
        allMap.put(code, stock);
    }

    public static void putAll(Map<String, Stock> allStockMap) {
        if(StringUtils.isEmpty(allStockMap)) {
            return;
        }
        for (Map.Entry<String, Stock> entry : allStockMap.entrySet()) {
            allMap.put(entry.getKey(), entry.getValue());
        }
    }

    public static void putAll(List<Stock> stocks) {
        if(StringUtils.isEmpty(stocks)) {
            return;
        }
        // 存在在内存中
        for (Stock stock : stocks) {
            if (StringUtils.isNotEmpty(stock.getCode())) {
                allMap.put(stock.getCode(), stock);
            }
        }
    }

    public static boolean containsKey(String code) {
        if(StringUtils.isEmpty(code)) {
            return false;
        }
        return allMap.containsKey(code);
    }

    public static boolean isEmpty() {
        return StringUtils.isEmpty(allMap);
    }

    public static Stock get(String stockCode) {
        if(StringUtils.isEmpty(stockCode)) {
            return null;
        }
        return allMap.get(stockCode);
    }

    public static List<Stock> getAllList() {
        return new ArrayList<>(allMap.values());
    }

    public static void clearZero() {
        if(!allMap.isEmpty()) {
            for (String code : allMap.keySet()) {
                // 不清指数
                if(Symbols.indexSymbols.contains(code)) {
                    continue;
                }
                Stock stock = allMap.get(code);
                stock.setPrice(BigDecimal.ZERO);
                stock.setIncrease(BigDecimal.ZERO);
                stock.setRisefall(BigDecimal.ZERO);

                stock.setOpenPrice(BigDecimal.ZERO);

                stock.setHighPrice(BigDecimal.ZERO);
                stock.setLowPrice(BigDecimal.ZERO);

                stock.setVol(0L);
                stock.setAmount(BigDecimal.ZERO);

                // 不清涨跌幅,因为qts早上8点推送一次涨跌幅，在数据清盘之前
                //stock.setRiseStopPrice(BigDecimal.ZERO);
                //stock.setFallStopPrice(BigDecimal.ZERO);

                allMap.put(code, stock);
            }
        }
    }
}
