package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.FiveMinuteChanage;
import com.shenhai.tech.market.project.strategy.entity.Stock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class FiveMinuteChanageCache {
    public static ConcurrentMap<String, FiveMinuteChanage> fiveMinuteChanageMap = new ConcurrentHashMap<>();

    public static void put(String code, FiveMinuteChanage fiveMinuteChanage) {
        if(StringUtils.isEmpty(code) || fiveMinuteChanage == null) {
            return;
        }
        fiveMinuteChanageMap.put(code, fiveMinuteChanage);
    }

    public static Map<String, FiveMinuteChanage> getFiveMinuteChanageMap() {
        return fiveMinuteChanageMap;
    }

    public static ConcurrentMap<String, Stock> hisStockMap = new ConcurrentHashMap<>();
    public static ConcurrentMap<String, Stock> getHisStockMap() {
        return hisStockMap;
    }
    public static void putHisStock(Map<String, Stock> stockMap) {
        if(StringUtils.isEmpty(stockMap)) {
            return;
        }
        for (Stock stockVO : stockMap.values()) {
            if(StringUtils.isNotEmpty(stockVO.getCode())) {
                hisStockMap.put(stockVO.getCode(), stockVO);
            }
        }
    }
}
