package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.BlockStock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BlockStockCache {
    public static ConcurrentMap<String, BlockStock> allMap = new ConcurrentHashMap<>();

    public static Map<String, BlockStock> getAllMap() {
        return allMap;
    }

    public static List<BlockStock> getList() {
        return new ArrayList<>(allMap.values());
    }

    public static void putAll(Map<String, BlockStock> stockMap) {
        if(StringUtils.isEmpty(stockMap)) {
            return;
        }
        for (String code : stockMap.keySet()) {
            allMap.put(code, stockMap.get(code));
        }
    }

    public static void putAll(List<BlockStock> blockStocks) {
        if(StringUtils.isEmpty(blockStocks)) {
            return;
        }
        for (BlockStock stock : blockStocks) {
            if(StringUtils.isNotEmpty(stock.getCode())) {
                allMap.put(stock.getCode(), stock);
            }
        }
    }

    public static void put(String code, BlockStock blockStock) {
        if(StringUtils.isEmpty(code) || blockStock == null) {
            return;
        }
        allMap.put(code, blockStock);
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

    public static BlockStock get(String code) {
        if(StringUtils.isEmpty(code)) {
            return null;
        }
        return allMap.get(code);
    }
}
