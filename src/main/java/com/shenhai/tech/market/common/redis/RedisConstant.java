package com.shenhai.tech.market.common.redis;

public class RedisConstant {
    // 停牌
    public static final String MARKET_STOCK_SUSPENSION = "market:stock:suspension:%s";
    // 退市
    public static final String MARKET_STOCK_DELIST = "market:stock:delist:%s";

    public static final String MARKET_STOCK_ALL = "market:stock:all";
    public static final String MARKET_STOCK_QUOTA = "market:stock:quota";

    public static String format(String key, String subKey) {
        return String.format("%s%s", key, subKey);
    }
}

