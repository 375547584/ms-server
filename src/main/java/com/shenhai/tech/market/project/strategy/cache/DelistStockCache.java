package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.DelistStock;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DelistStockCache {
    public static ConcurrentMap<String, List<DelistStock>> allMap = new ConcurrentHashMap<>();

    public static ConcurrentMap<String, List<DelistStock>> getAllMap() {
        return allMap;
    }

    public static void putAll(Map<String, List<DelistStock>> map) {
        if(StringUtils.isEmpty(map)) {
            return;
        }
        for (String code : map.keySet()) {
            allMap.put(code, map.get(code));
        }
    }

    public static void put(String code, List<DelistStock> list) {
        if(StringUtils.isEmpty(code) || list == null) {
            return;
        }
        allMap.put(code, list);
    }

    public static boolean containsKey(String stockCode) {
        if(StringUtils.isEmpty(stockCode)) {
            return false;
        }
        return allMap.containsKey(stockCode);
    }

    public static boolean isEmpty() {
        return StringUtils.isEmpty(allMap);
    }

    public static List<DelistStock> get(String stockCode) {
        if(StringUtils.isEmpty(stockCode)) {
            return null;
        }
        return allMap.get(stockCode);
    }
}
