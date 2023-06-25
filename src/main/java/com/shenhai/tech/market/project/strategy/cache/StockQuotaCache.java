package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.GZIPUtils;
import com.shenhai.tech.market.common.utils.JSONUtils;
import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.StockQuota;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StockQuotaCache {
    private static final ConcurrentMap<String, StockQuota> allMap = new ConcurrentHashMap<>();
    public static ConcurrentMap<String, StockQuota> getAllMap() {
        return allMap;
    }

    public static void put(String code, StockQuota stockQuota) {
        if(StringUtils.isEmpty(code)) {
            return;
        }
        allMap.put(code, stockQuota);
    }

    public static void putAll(Map<String, StockQuota> allStockMap) {
        if(StringUtils.isEmpty(allStockMap)) {
            return;
        }
        for (Map.Entry<String, StockQuota> entry : allStockMap.entrySet()) {
            allMap.put(entry.getKey(), entry.getValue());
        }
    }

    public static void putAll(List<StockQuota> stocks) {
        if(StringUtils.isEmpty(stocks)) {
            return;
        }
        // 存在在内存中
        for (StockQuota stockQuota : stocks) {
            if (StringUtils.isNotEmpty(stockQuota.getCode())) {
                allMap.put(stockQuota.getCode(), stockQuota);
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

    public static StockQuota get(String stockCode) {
        if(StringUtils.isEmpty(stockCode)) {
            return null;
        }
        return allMap.get(stockCode);
    }

    public static List<StockQuota> getAllList() {
        return new ArrayList<>(allMap.values());
    }

    public static String getCompress() {
        String dataStr = JSONUtils.toJson(StockQuotaCache.getAllList());
        return Base64.getEncoder().encodeToString(GZIPUtils.compress(dataStr));
    }
}
