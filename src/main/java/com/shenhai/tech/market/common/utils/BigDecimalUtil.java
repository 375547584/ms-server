package com.shenhai.tech.market.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class BigDecimalUtil {
    public static Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    public static BigDecimal multiply(Long a, BigDecimal b) {
        return BigDecimal.valueOf(a).multiply(b);
    }

    public static BigDecimal multiply(Integer a, BigDecimal b) {
        return BigDecimal.valueOf(a).multiply(b);
    }

    public static Integer multiplyToInt(Integer a, BigDecimal b) {
        BigDecimal value = multiplyNoScale(a, b);
        return Integer.valueOf(value.toString());
    }

    public static BigDecimal multiply(BigDecimal a, Integer b) {
        return BigDecimal.valueOf(b).multiply(a);
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b, BigDecimal c) {
        return a.multiply(b).multiply(c);
    }

    public static BigDecimal multiplyNoScale(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(0, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiplyNoScale(Integer a, BigDecimal b) {
        return BigDecimal.valueOf(a).multiply(b).setScale(0, RoundingMode.HALF_UP);
    }

    /**
     * 保留2位小数
     *
     * @param a
     * @return
     */
    public static BigDecimal to2Scale(BigDecimal a) {
        if (a == null) {
            return null;
        }
        return a.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * a 乘于 b 结果保留2位小数
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal multiply2Scale(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiply2Scale(BigDecimal a, Integer b) {
        return a.multiply(BigDecimal.valueOf(b)).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiply2Scale(Integer a, BigDecimal b) {
        return BigDecimal.valueOf(a).multiply(b).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiply2Scale(BigDecimal a, Integer b, BigDecimal c) {
        return a.multiply(BigDecimal.valueOf(b)).multiply(c).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiply2Scale(BigDecimal a, BigDecimal b, Integer c, Integer d) {
        return a.multiply(b).multiply(BigDecimal.valueOf(c)).multiply(BigDecimal.valueOf(d)).setScale(2,
                RoundingMode.HALF_UP);
    }

    public static BigDecimal multiply2Scale(BigDecimal a, Integer b, BigDecimal c, Integer d) {
        return a.multiply(BigDecimal.valueOf(b)).multiply(c).multiply(BigDecimal.valueOf(d)).setScale(2,
                RoundingMode.HALF_UP);
    }

    public static BigDecimal divide2Scale(BigDecimal a, Integer b) {
        if(a == null || BigDecimalUtil.eqZero(a) || b == null || b == 0) {
            return null;
        }
        return a.divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide2Scale(BigDecimal a, Long b) {
        if(a == null || BigDecimalUtil.eqZero(a) || b == null || b == 0) {
            return null;
        }
        return a.divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide10Scale(BigDecimal a, Integer b) {
        return a.divide(BigDecimal.valueOf(b), 10, RoundingMode.HALF_UP);
    }

    /**
     * 除 a/b
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal divide2Digit(BigDecimal a, Integer b) {
        return a.divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
    }

    /**
     * 除 a/b(保留整数)
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal divide0Digit(BigDecimal a, Integer b) {
        return a.divide(BigDecimal.valueOf(b), 0, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide2Scale(BigDecimal a, BigDecimal b) {
        return a.divide(b, 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide4Scale(BigDecimal a, BigDecimal b) {
        return a.divide(b, 4, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide4Scale(BigDecimal a, Integer b) {
        return a.divide(BigDecimal.valueOf(b), 4, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide100002Scale(BigDecimal a) {
        if (a == null) {
            return BigDecimal.ZERO;
        }
        return a.divide(BigDecimal.valueOf(10000), 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide100(BigDecimal a) {
        if (a == null) {
            return BigDecimal.ZERO;
        }
        return a.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide100(Long a) {
        if (a == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(a).divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
    }

    public static Long divide100L(Long a) {
        if (a == null) {
            return 0L;
        }
        return Long.valueOf(a / 100);
    }

    public static Integer divide100(Integer a) {
        if (a == null) {
            return 0;
        }
        return a / 100;
    }

    public static BigDecimal divide100Scale8(BigDecimal a) {
        if (a == null) {
            return BigDecimal.ZERO;
        }
        return a.divide(BigDecimal.valueOf(100), 8, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide100Scale2(BigDecimal a) {
        if (a == null) {
            return BigDecimal.ZERO;
        }
        return a.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide4Scale(Integer a, Integer b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 4, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide8Scale(BigDecimal a, BigDecimal b) {
        return a.divide(b, 8, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide8Scale(BigDecimal a, Integer b) {
        return a.divide(BigDecimal.valueOf(b), 8, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide2Scale(Integer a, Integer b) {
        DecimalFormat df = new DecimalFormat("0.00");
        return new BigDecimal(df.format((float) a / b));
    }

    /**
     * 取小
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal sub(BigDecimal a, BigDecimal b) {
        return a.min(b);
    }


    public static BigDecimal plus(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
        return a.add(b).add(c).add(d);
    }

    public static BigDecimal plus(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d, BigDecimal e, BigDecimal f, BigDecimal g, BigDecimal h) {
        return a.add(b).add(c).add(d).add(e).add(f).add(g).add(h);
    }

    /**
     * a 加 b
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal plus(BigDecimal a, BigDecimal b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        return a.add(b);
    }

    /**
     * a 加 b
     *
     * @param a
     * @param b
     * @return
     */
    public static Long plus(Integer a, Long b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return Long.valueOf(a);
        }
        return a + b;
    }

    /**
     * a 加 b 减 c
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal plusThree(BigDecimal a, BigDecimal b, BigDecimal c) {
        return a.add(b).subtract(c);
    }

    /**
     * a 加 b
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer plus(Integer a, Integer b) {
        return a + b;
    }

    public static BigDecimal plus(BigDecimal a, BigDecimal b, BigDecimal c) {
        return a.add(b).add(c);
    }

    public static Integer plus(Integer a, Integer b, Integer c) {
        return a + b + c;
    }

    /**
     * a 减去 b
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal minus2Scale(BigDecimal a, BigDecimal b) {
        return a.subtract(b).setScale(2);
    }

    /**
     * a 减去 b
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal minus(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) {
            return BigDecimal.ZERO;
        }
        return a.subtract(b);
    }


    /**
     * a 减去 b
     *
     * @param a
     * @param b
     * @return
     */
    public static Long minus(Long a, Long b) {
        if (a == null || b == null) {
            return 0L;
        }
        return a - b;
    }

    /**
     * a 减去 b
     *
     * @param a
     * @param b
     * @return
     */
    public static Integer minus(Integer a, Integer b) {
        if (a == null || b == null) {
            return 0;
        }
        return a - b;
    }

    /**
     * a 减去 b 减去 c
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static BigDecimal minus(BigDecimal a, BigDecimal b, BigDecimal c) {
        return a.subtract(b).subtract(c);
    }

    /**
     * a 减去 b 减去 c 减去 d
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static BigDecimal minusfour(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
        return a.subtract(b).subtract(c).subtract(d);
    }

    /**
     * 大于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean gt(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) > 0;
    }

    /**
     * 大于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean gt(Integer a, Integer b) {
        return a.compareTo(b) > 0;
    }

    /**
     * 大于0
     *
     * @param a
     * @return
     */
    public static boolean gtZero(BigDecimal a) {
        if (a == null) {
            return false;
        }
        return a.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * 大于0
     *
     * @param a
     * @return
     */
    public static boolean gtZero(Integer a) {
        if (a == null) {
            return false;
        }
        return a.compareTo(0) > 0;
    }

    /**
     * 大于等于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean ge(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) >= 0;
    }

    /**
     * 大于等于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean ge(Integer a, Integer b) {
        return a.compareTo(b) >= 0;
    }

    /**
     * 大于等于0
     *
     * @param a
     * @return
     */
    public static boolean geZero(BigDecimal a) {
        return a.compareTo(BigDecimal.ZERO) >= 0;
    }

    /**
     * 等于0
     *
     * @param a
     * @return
     */
    public static boolean eqZero(BigDecimal a) {
        if (a == null) {
            return true;
        }
        return a.compareTo(BigDecimal.ZERO) == 0;
    }

    /**
     * 等于0
     *
     * @param a
     * @return
     */
    public static boolean eqZero(Long a) {
        if (a == null) {
            return true;
        }
        return a.equals(0L);
    }

    /**
     * 等于0
     *
     * @param a
     * @return
     */
    public static boolean eqZero(Integer a) {
        return a.equals(0);
    }

    /**
     * 小于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean lt(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 小于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean lt(Integer a, Integer b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 等于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean eq(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) {
            return false;
        }
        return a.compareTo(b) == 0;
    }

    /**
     * 等于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean eq(Integer a, Integer b) {
        return a.compareTo(b) == 0;
    }

    /**
     * 小于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean lt(BigDecimal a, Integer b) {
        return a.compareTo(BigDecimal.valueOf(b)) < 0;
    }

    /**
     * 小于0
     *
     * @param a
     * @return
     */
    public static boolean ltZero(BigDecimal a) {
        return a.compareTo(BigDecimal.ZERO) < 0;
    }

    /**
     * 小于等于0
     *
     * @param a
     * @return
     */
    public static boolean lteqZero(BigDecimal a) {
        return a.compareTo(BigDecimal.ZERO) < 0;
    }

    /**
     * 小于等于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean le(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) <= 0;
    }

    /**
     * 小于等于
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean le(Integer a, Integer b) {
        return a.compareTo(b) <= 0;
    }

    /**
     * 小于等于0
     *
     * @param a
     * @return
     */
    public static boolean leeqZero(Integer a) {
        if (a == null) {
            return true;
        }
        return a.compareTo(0) <= 0;
    }

    /**
     * 小于等于0
     *
     * @param a
     * @return
     */
    public static boolean leeqZero(BigDecimal a) {
        return a.compareTo(BigDecimal.ZERO) <= 0;
    }

    /**
     * 去最大
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal selectMaximum(BigDecimal a, BigDecimal b) {
        return gt(a, b) ? a : b;
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    public static BigDecimal abs(BigDecimal a) {
        if(a == null) {
            return null;
        }
        return a.abs();
    }

    public static BigDecimal total(BigDecimal a, BigDecimal b, BigDecimal c) {
        return a.multiply(b).add(c);
    }

    /**
     * 保留两位小数，后面的直接舍弃
     *
     * @param a
     * @return
     */
    public static BigDecimal sub2Decimal(BigDecimal a) {
        if(a == null) {
            return a;
        }
        return a.setScale(2, RoundingMode.DOWN);
    }

    /**
     * 保留两位小数，四舍五入
     *
     * @param a
     * @return
     */
    public static BigDecimal reserve2Decimal(BigDecimal a) {
        if(a == null) {
            return a;
        }
        return a.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * (a-b)*c
     *
     * @param a
     * @return
     */
    public static BigDecimal sub3Decimal(BigDecimal a, BigDecimal b, Integer c) {
        return (a.subtract(b)).multiply(new BigDecimal(c)).setScale(2, RoundingMode.DOWN);
    }

    /**
     * 是否是100的倍数
     */
    public static boolean ismultiple(BigDecimal a) {
        return a.intValue() % 100 == 0;
    }

    /**
     * 是否是另一个数倍数
     */
    public static boolean ismultiple(BigDecimal a, BigDecimal b) {
        return a.intValue() % b.intValue() == 0;
    }

    /**
     * 将结果转化成百分比
     */
    public static String toPercent(BigDecimal a) {
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        if (a == null) {
            return percent.format(0D);
        }
        return percent.format(a.doubleValue());
    }

    /**
     * 将结果转化成百分比
     */
    public static String toPercent100(BigDecimal a) {
        BigDecimal divValue = BigDecimalUtil.divide8Scale(a, 100);
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        return percent.format(divValue.doubleValue());
    }

    public static BigDecimal multiply100(BigDecimal a) {
        if(a == null) {
            return null;
        }
        return multiply(a, 100);
    }
    public static BigDecimal multiply10(BigDecimal a) {
        if(a == null) {
            return null;
        }
        return multiply(a, 10);
    }
    public static void main(String[] args) throws ParseException {
        /*
         * BigDecimal floatingProfitAndLossRate =
         * BigDecimalUtil.divide4Scale(BigDecimalUtil.minus(100, 150), 150);
         * //String floatingProfitAndLossRateStr =
         * BigDecimalUtil.percentage(BigDecimalUtil.multiply2Scale(
         * floatingProfitAndLossRate, 100));
         * //System.out.println(floatingProfitAndLossRateStr);
         * String floatingProfitAndLossRateStr1 =
         * BigDecimalUtil.toPercent(floatingProfitAndLossRate);
         * System.out.println(floatingProfitAndLossRateStr1);
         * BigDecimal a = BigDecimal.valueOf(0.3303);
         * NumberFormat percent = NumberFormat.getPercentInstance();
         * percent.setMaximumFractionDigits(2);
         * String rate = percent.format(a.doubleValue());
         */
        // System.out.println(divide100Scale2(new BigDecimal(50)));
        /*
         * System.out.println(toPercent(new BigDecimal(0.3500)));
         * Integer registrationPositionNumber = 1000;
         * Integer bonus = 4;
         * Integer giftNumber = registrationPositionNumber * bonus / 10 ;
         */
        //System.out.println(toPercent100(BigDecimal.valueOf(45)));
        // System.out.println(BigDecimalUtil.plus(new BigDecimal(100), new
        // BigDecimal(50)).setScale(2, RoundingMode.HALF_UP));
        //System.out.println(BigDecimalUtil.eq(new BigDecimal(3), new BigDecimal(3)));

        Double num2 = (Double) NumberFormat.getPercentInstance().parse("30.86%");
        BigDecimal scale = new BigDecimal(num2).setScale(2, RoundingMode.HALF_UP);
        System.out.println(num2);
        System.out.println(scale);
    }

    /**
     * 将百分比结果转化成BigDecimal(带百分号数据)
     * 除于divnum
     */
    public static BigDecimal percentToBigDecimal(String a) {
        BigDecimal scale;
        try {
            Double num2 = (Double) NumberFormat.getPercentInstance().parse(a);
            scale = new BigDecimal(num2).setScale(2, RoundingMode.HALF_UP);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return scale;
    }

    public static String toString2(BigDecimal value) {
        if (value == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value);
    }

    public static String toString4(BigDecimal value) {
        if (value == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        return df.format(value);
    }

    public static String toString6(BigDecimal value) {
        if (value == null) {
            return null;
        }
        DecimalFormat df = new DecimalFormat("0.000000");
        return df.format(value);
    }

    public static Integer valuseToInt(String str) {
        Integer value = 0;
        try {
            value = new Integer(str);
        } catch (Exception e) {

        }
        return value;
    }

    public static BigDecimal valuseOf(String str) {
        BigDecimal value = BigDecimal.ZERO;
        try {
            value = new BigDecimal(str);
        } catch (Exception e) {

        }
        return value;
    }

    public static String getStrPrice(BigDecimal price) {
        if (price == null) {
            return "--";
        }
        return String.format("%.2f", price);
    }


}
