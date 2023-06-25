package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.LocalDateUtils;
import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.Suspension;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SuspensionCache {
    public static ConcurrentMap<String, List<Suspension>> allMap = new ConcurrentHashMap<>();

    public static ConcurrentMap<String, List<Suspension>> getAllMap() {
        return allMap;
    }

    public static void putAll(Map<String, List<Suspension>> map) {
        if(StringUtils.isEmpty(map)) {
            return;
        }
        for (String code : map.keySet()) {
            allMap.put(code, map.get(code));
        }
    }

    public static void put(String code, List<Suspension> list) {
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

    public static List<Suspension> get(String stockCode) {
        if(StringUtils.isEmpty(stockCode)) {
            return null;
        }
        return allMap.get(stockCode);
    }

    public static boolean isSuspension(String code) {
        String date = LocalDateUtils.format(LocalDate.now(), LocalDateUtils.formatterDD3);
        if(allMap.containsKey(date)){
            List<Suspension> suspensions = allMap.get(date);
            if(StringUtils.isNotEmpty(suspensions)) {
                for (Suspension suspension : suspensions) {
                    if(suspension.getStockCode().equalsIgnoreCase(code)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
