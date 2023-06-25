package com.shenhai.tech.market.common.redis;

public class RedisKey {
    public static String format(String prefix, String subKey) {
        return  String.format(prefix, subKey);
    }

    public static String format(String prefix, Integer subKey) {
        return  String.format(prefix, subKey);
    }

    public static String format(String prefix, String subKey1, Integer subKey2) {
        return  String.format(prefix, subKey1, subKey2);
    }

    public static String format(String prefix, String subKey1, String subKey2,String subKey3) {
        return  String.format(prefix, subKey1,subKey2,subKey3);
    }
    public static String format(String prefix, Integer subKey1, Integer subKey2, String subKey3) {
        return  String.format(prefix, subKey1,subKey2,subKey3);
    }
}
