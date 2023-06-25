package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.BlockType;
import com.shenhai.tech.market.project.strategy.zlhq.entity.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BlockCache {
    private static ConcurrentMap<String, Block> allMap = new ConcurrentHashMap<>();

    public static Map<String, Block> getAllMap() {
        return BlockCache.allMap;
    }

    public static void putAllMap(Map<String, Block> blockMap) {
        if(StringUtils.isEmpty(blockMap)) {
            return;
        }
        for (Block block : blockMap.values()) {
            if(StringUtils.isNotEmpty(block.getSymbol())) {
                BlockCache.allMap.put(block.getSymbol(), block);
            }
        }
    }

    public static boolean isEmpty() {
        return StringUtils.isEmpty(allMap);
    }

    public static Block get(String code) {
        if(StringUtils.isEmpty(code)) {
            return null;
        }
        return allMap.get(code);
    }
}
