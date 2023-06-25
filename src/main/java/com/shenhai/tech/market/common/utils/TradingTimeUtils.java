package com.shenhai.tech.market.common.utils;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A股集合竞价时间为9点15分至9点25分，14点57分至15点00分
 * 9点15分至9点20分，根据买卖双方挂单，预先撮合，不成交
 * 9点20分至9点25分，可申报不可撤销，9点25分之前都不成交
 * 交易时间判断
 * 集合竞价:(开盘价如何产生)每天交易开始前，即：9点15分到9点25分，沪深证交所开始接受股民有效的买卖指令
 * 9点30分正式开盘
 * <p>
 * 中国上海证券交易所和深圳证券交易所对股票和基金交易实行“T+1”的交易方式，中国股市实行“T+1”交易制度，当日买进的股票，要到下一个交易日才能卖出。
 * T+1是一种股票交易制度，即当日买进的股票，要到下一个交易日才能卖出
 * <p>
 * 股市交易时间为每周一到周五上午时段9:30-11:30，下午时段13:00-15:00.周六、周日及上海证券交易所、深圳证券交易所公告的休市日不交易。
 */
public class TradingTimeUtils {

    /**
     * 早上9:30(正式开盘时间)
     */
    private static LocalTime amBeginTimeV1 = LocalTime.of(9, 30);
    /**
     * 中午11:30(中午正式停盘时间)
     */
    private static LocalTime amEndTimeV1 = LocalTime.of(11, 30);

    /**
     * 中午13:00(中午正式开盘时间)
     */
    private static LocalTime pmBeginTimeV1 = LocalTime.of(13, 00);
    /**
     * 下午15:00(中午正式停盘时间)
     */
    private static LocalTime pmEndTimeV1 = LocalTime.of(15, 00);



    /**
     * 盘后交易的开始时间:15:05(科创板 创业板)
     */
    private static LocalTime afterTradingBeginTime = LocalTime.of(15, 05);
    /**
     * 盘后交易的开始时间:15:30(科创板 创业板)
     */
    private static LocalTime afterTradingEndTime = LocalTime.of(15, 30);




    /**
     * 在上集合竞价开始时间:9:15
     */
    private static LocalTime morningAuctionBeginTime = LocalTime.of(9, 15);
    /**
     * 早上集合竞价结束时间:9:25
     */
    private static LocalTime morningAuctionEndTime = LocalTime.of(9, 25);

    /**
     * 下午集合竞价开始时间:14:57
     */
    private static LocalTime afterNoonAuctionBeginTime = LocalTime.of(14, 57);
    /**
     * 下午集合竞价结束时间:15:00
     */
    private static LocalTime afterNoonAuctionEndTime = LocalTime.of(15, 00);

    /**
     * 开盘准备开始时间:9:25
     */
    private static LocalTime openPrepareBeginTime = LocalTime.of(9, 25);
    /**
     * 开盘准备结束时间:9:30
     */
    private static LocalTime openPrepareEndTime = LocalTime.of(9, 30);




    /**
     * 股票数据刷新中午开始时间
     */
    private static LocalTime amBeginRefreshStockV1 = LocalTime.of(9, 15);
    /**
     * 股票数据刷新中午结束时间
     */
    private static LocalTime amEndRefreshStockV1 = LocalTime.of(11, 31);
    /**
     * 股票数据刷新下午开始时间
     */
    private static LocalTime pmBeginRefreshStockV1 = LocalTime.of(13, 0);
    /**
     * 股票数据刷新下午结束时间
     */
    private static LocalTime pmEndRefreshStockV1 = LocalTime.of(15, 1);



    /**
     * 指数数据刷新早上开始时间
     */
    private static LocalTime amBeginRefreshIndexV1 = LocalTime.of(9, 15);
    /**
     * 指数数据刷新早上结束时间
     */
    private static LocalTime amEndRefreshIndexV1 = LocalTime.of(11, 31);

    /**
     * 指数数据刷新下午开始时间
     */
    private static LocalTime pmBeginRefreshIndexV1 = LocalTime.of(13, 0);
    /**
     * 指数数据刷新下午结束时间
     */
    private static LocalTime pmEndRefreshIndexV1 = LocalTime.of(15, 31);


    private static LocalTime beginRefreshhQuotasV1 = LocalTime.of(9, 15);
    private static LocalTime endRefreshhQuotasV1 = LocalTime.of(16, 0);


    // 开始清数据的时间
    private static LocalTime beginClearTimeV1 = LocalTime.of(9, 5);
    // 结束清数据的时间
    private static LocalTime endClearTimeV1 = LocalTime.of(9, 15);

    /**
     * 早上等未开盘的时间-只用于状态判断
     * 早上00:00-09:30
     * @param holidays
     * @return
     */
    public static boolean isWaitOpen(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        return LocalTime.now().isAfter(LocalTime.of(0, 0)) && LocalTime.now().isBefore(LocalTime.of(9, 30));
    }

    /**
     * 当前是否集体竞价时间
     * 9点15分至9点25分，
     * 14点57分至15点00分 属于集合竞价时间
     *
     * @return
     */
    public static boolean isCallAuctionTime(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        return isCallAuctionMorningTime() || isCallAuctionAfternoonTime();
    }

    /**
     * 在上集合竞价开始时间:9:15-9:25
     * @param holidays
     * @return
     */
    public static boolean isCallAuctionMorningTime(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        return isCallAuctionMorningTime();
    }

    /**
     * 下午集合竞价时间:14:57-:15:00
     * @return
     */
    private static boolean isCallAuctionAfternoonTime() {
        LocalTime nowTime = LocalTime.now();
        return TimeUtils.isSomeTimeInterval(nowTime, afterNoonAuctionBeginTime, afterNoonAuctionEndTime);
    }

    /**
     * 早上集合竞价时间:9:15-:9:25
     * @return
     */
    private static boolean isCallAuctionMorningTime() {
        LocalTime nowTime = LocalTime.now();
        return TimeUtils.isSomeTimeInterval(nowTime, morningAuctionBeginTime, morningAuctionEndTime);
    }

    /**
     * 中午等未开盘的时间-只用于状态判断
     * 早上11:30-13:00
     * @param holidays
     * @return
     */
    public static boolean isNoonClosedMarketTimeV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        // 早上11:31:00到下午12:59:59
        return TimeUtils.isSomeTimeInterval(LocalTime.now(), LocalTime.of(11, 30), LocalTime.of(13, 0));
    }




    /**
     * 从开始清除数据到开盘的时间段
     *  早上9:05-9:30
     * @param holidays
     * @return
     */
    public static boolean isClearToOpenTimeV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        // 早上9:05到下午9:30
        return TimeUtils.isSomeTimeInterval(LocalTime.now(), beginClearTimeV1, amBeginTimeV1);
    }

    /**
     * 清数据时间
     *  早上9:05-9:15
     * @param holidays
     * @return
     */
    public static boolean isClearTimeV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        // 早上9:05到下午9:30
        return TimeUtils.isSomeTimeInterval(LocalTime.now(), beginClearTimeV1, endClearTimeV1);
    }

    /**
     * 清除分时曲线的时间
     *  早上9:05-9:30
     * @param holidays
     * @return
     */
    public static boolean isMinuteRealTimeKLineClearTimeV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        // 早上9:05到下午9:30
        return TimeUtils.isSomeTimeInterval(LocalTime.now(), LocalTime.of(9, 5), LocalTime.of(9, 30));
    }

    /**
     *  清除逐笔行情的时间
     *  早上9:05-9:15
     * @param holidays
     * @return
     */
    public static boolean isStepTransactionClearTimeV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        // 早上9:05到下午9:30
        return TimeUtils.isSomeTimeInterval(LocalTime.now(), LocalTime.of(9, 5), LocalTime.of(9, 15));
    }


    /**
     * 9:30~ 11:35 && 13:00 ~ 15:35
     * @param holidays
     * @return
     */
    public static boolean isRtMinuteTimeV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        // 9:25 ~ 11:31 && 13:00 ~ 15:31
        return TimeUtils.isSomeTimeInterval(LocalTime.now(), LocalTime.of(9, 30), LocalTime.of(11, 35)) || TimeUtils.isSomeTimeInterval(LocalTime.now(), LocalTime.of(13, 0), LocalTime.of(15, 35));
    }




    /**
     * 是否是A股票交易时间
     * 9:30 ~ 11:30 && 13:00 ~ 15:00
     *
     * @return
     */
    public static boolean isTreadingTimeV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        // 早上9:30到中午11:30 或者  中午午13:00到下午15:00
        return isTreadingTimeV1();

    }

    /**
     * 是否是A股票交易时间
     * 9:30 ~ 11:30 && 13:00 ~ 15:30
     *
     * @return
     */
    public static boolean isTreadingTimeV1(String holidays, String code) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        if (StockUtils.isKCB(code) || StockUtils.isCYB(code)) {
            return isAfterTradingTime() || isTreadingTimeV1();
        } else {
            return isTreadingTimeV1();
        }
    }

    /**
     * 是否是A股票交易时间
     * 9:30 ~ 11:30 && 13:00 ~ 15:00
     *
     * @return
     */
    public static boolean isTreadingTimeV1() {
        LocalTime nowTime = LocalTime.now();
        // 早上9:30到中午11:30 或者  中午午13:00到下午15:00
        return TimeUtils.isSomeTimeInterval(nowTime, amBeginTimeV1, amEndTimeV1) || TimeUtils.isSomeTimeInterval(nowTime, pmBeginTimeV1, pmEndTimeV1);
    }


    /**
     * 当前是否属于盘后交易时间
     * 15:05 15:30以后禁止买入和卖出成交
     *
     * @return
     */
    private static boolean isAfterTradingTime() {
        return TimeUtils.isSomeTimeInterval(LocalTime.now(), afterTradingBeginTime, afterTradingEndTime);
    }


    /**
     * 获取上一股票交易日
     *
     * @return
     */
    public static LocalDate getPreTradeDay(LocalDate date, String holidays) {
        if (date == null) {
            return null;
        }
        if (StringUtils.isEmpty(holidays)) {
            return null;
        }
        LocalDate localDate = date.minusDays(1);
        while (true) {
            String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
            if (holidays.contains(localDateStr) || localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                localDate = localDate.minusDays(1);
            } else {
                break;
            }
        }
        return localDate;
    }

    /**
     * 当前是否为交易日
     * @param holidays
     * @return
     */
    public static boolean isTreadingDayV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        return true;
    }


    /**
     * 是否是股票数据刷新时间
     * 早上9:15到中午11:30 或者  中午午13:00到下午15:01
     * @param holidays
     * @return
     */
    public static boolean isRefreshQuotasV1(String holidays) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().getValue() > 5) {
            return false;
        }
        String localDateStr = LocalDateUtils.format(localDate, LocalDateUtils.formatterDD3);
        if (StringUtils.isNotEmpty(holidays) && holidays.contains(localDateStr)) {
            return false;
        }
        LocalTime nowTime = LocalTime.now();
        // 早上9:25到中午11:30 或者  中午午13:00到下午15:01
        return TimeUtils.isSomeTimeInterval(nowTime, beginRefreshhQuotasV1, endRefreshhQuotasV1);
    }
}
