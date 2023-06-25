package com.shenhai.tech.market.project.strategy.cache;

import com.google.gson.reflect.TypeToken;
import com.shenhai.tech.market.common.utils.GZIPUtils;
import com.shenhai.tech.market.common.utils.JSONUtils;
import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.strategy.entity.RTKLine;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RtKLineCache {

    public static ConcurrentMap<String,  List<RTKLine>> allMap = new ConcurrentHashMap<>();

    public static Map<String, List<RTKLine>> getAllMap() {
        return allMap;
    }

    public static void putAll(Map<String,  List<RTKLine>> map) {
        if(StringUtils.isEmpty(map)) {
            return;
        }
        for (Map.Entry<String,  List<RTKLine>> entry : map.entrySet()) {
            allMap.remove(entry.getKey());
            allMap.put(entry.getKey(), entry.getValue());
        }
    }

    public static void put(String code, List<RTKLine> list) {
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(list)) {
            return;
        }
        allMap.remove(code);
        allMap.put(code, list);
    }

    public static List<RTKLine> get(String code) {
        if(StringUtils.isEmpty(code)) {
            return null;
        }
        return allMap.get(code);
    }

    public static Map<String, List<RTKLine>> get(List<String> codes) {
        if(StringUtils.isEmpty(codes)) {
            return new HashMap<>();
        }
        Map<String, List<RTKLine>> resultMap = new HashMap<>();
        for (String code : codes) {
            List<RTKLine> rtkLines = allMap.get(code);
            resultMap.put(code, rtkLines);
        }
        return resultMap;
    }

    public static boolean isEmpty() {
        return StringUtils.isEmpty(allMap);
    }



    public static String getCompress() {
        String dataStr = JSONUtils.toJson(RtKLineCache.getAllMap());
        return Base64.getEncoder().encodeToString(GZIPUtils.compress(dataStr));
    }

    public static void clear() {
        allMap.clear();
    }
}
