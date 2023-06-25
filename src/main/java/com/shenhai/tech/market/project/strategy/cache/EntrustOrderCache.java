package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.push.EntrustOrder;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EntrustOrderCache {
    public static ConcurrentMap<String, LinkedList<EntrustOrder>> allMap = new ConcurrentHashMap<>();

    public static Map<String, LinkedList<EntrustOrder>> getAllMap() {
        return allMap;
    }

    public static void putList(List<EntrustOrder> list) {
        if(StringUtils.isEmpty(list)) {
            return;
        }
        for (EntrustOrder entrustOrder : list) {
            if(StringUtils.isEmpty(entrustOrder.getCode())) {
                continue;
            }
            if(allMap.containsKey(entrustOrder.getCode())) {
                if(allMap.get(entrustOrder.getCode()).size() > 1000) {
                    allMap.get(entrustOrder.getCode()).removeLast();
                }
                allMap.get(entrustOrder.getCode()).addFirst(entrustOrder);
            }
            else {
                LinkedList<EntrustOrder> stepDetails = new LinkedList<>();
                stepDetails.addFirst(entrustOrder);
                allMap.put(entrustOrder.getCode(), stepDetails);
            }
        }
    }

    public static List<EntrustOrder> get(String code) {
        if(StringUtils.isEmpty(code)) {
            return null;
        }
        return allMap.get(code);
    }

    public static void clear() {
        allMap.clear();
    }

    public static boolean isEmpty() {
        return StringUtils.isEmpty(allMap);
    }
}
