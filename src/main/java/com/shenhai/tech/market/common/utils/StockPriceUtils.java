package com.shenhai.tech.market.common.utils;



import java.math.BigDecimal;

/****
 * 股票代码
 * 002开头的是中小板的
 * 000开头是深圳的
 * 300是创业板的
 * 600开头是上海交易所上市的股票
 */
public class StockPriceUtils {
    public static BigDecimal handleNull(BigDecimal b) {
        if(b == null) {
            return BigDecimal.ZERO;
        }
        return b;
    }

    public static BigDecimal handleNull(BigDecimal b, BigDecimal deflult) {
        if(b == null) {
            return deflult;
        }
        return b;
    }

    public static BigDecimal handleZero(BigDecimal b, BigDecimal deflult) {
        if(b == null || BigDecimalUtil.eqZero(b)) {
            return deflult;
        }
        return b;
    }

    public static Long handleNull(Long b, Long deflult) {
        if(b == null) {
            return deflult;
        }
        return b;
    }

    public static Long handleZero(Long b, Long deflult) {
        if(b == null || b == 0) {
            return deflult;
        }
        return b;
    }

    public static String handleNull(String b, String deflult) {
        if(b == null) {
            return deflult;
        }
        return b;
    }
}