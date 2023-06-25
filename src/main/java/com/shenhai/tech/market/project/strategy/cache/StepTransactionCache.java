package com.shenhai.tech.market.project.strategy.cache;

import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.push.StepTransaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StepTransactionCache {
    public static ConcurrentMap<String, LinkedList<StepTransaction>> allMap = new ConcurrentHashMap<>();

    public static Map<String, LinkedList<StepTransaction>> getAllMap() {
        return allMap;
    }

    public static void putList(List<StepTransaction> list) {
        if(StringUtils.isEmpty(list)) {
            return;
        }
        for (StepTransaction stepDetailVO : list) {
            if(StringUtils.isEmpty(stepDetailVO.getCode())) {
                continue;
            }
            if(allMap.containsKey(stepDetailVO.getCode())) {
                if(allMap.get(stepDetailVO.getCode()).size() > 1000) {
                    allMap.get(stepDetailVO.getCode()).removeLast();
                }
                allMap.get(stepDetailVO.getCode()).addFirst(stepDetailVO);
            }
            else {
                LinkedList<StepTransaction> stepDetails = new LinkedList<>();
                stepDetails.addFirst(stepDetailVO);
                allMap.put(stepDetailVO.getCode(), stepDetails);
            }
        }
    }


    public static List<StepTransaction> get(String code) {
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
