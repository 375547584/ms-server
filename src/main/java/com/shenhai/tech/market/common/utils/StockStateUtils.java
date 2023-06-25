package com.shenhai.tech.market.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class StockStateUtils {
    public static String genereateState(String holidays, boolean isSuspension) {
        if (StringUtils.isEmpty(holidays)) {
            return "未知";
        }

        String status;
        if (isSuspension) {
            status = "已停牌";
        } else {
            if(TradingTimeUtils.isTreadingTimeV1(holidays)) {
                status = "交易中";
            }
            else {
                if(TradingTimeUtils.isTreadingDayV1(holidays)) {
                    if(TradingTimeUtils.isWaitOpen(holidays)) {
                        status = "未开盘";
                    }
                    else {
                        status =  "已收盘";
                    }
                }
                else {
                    status =  "已收盘";
                }
            }
        }
        return status;
    }

    public static String genereateState(String stockCode, String holidays, Set<String> map) {
        String code = stockCode;
        if (StringUtils.isNotEmpty(stockCode)) {
            code = StockUtils.symbolToCode(stockCode);
        }

        if (StringUtils.isEmpty(holidays)) {
            return "未知";
        }

        String status;
        if (map != null && map.contains(code)) {
            status = "已停牌";
        } else {
            if(TradingTimeUtils.isTreadingTimeV1(holidays)) {
                status = "交易中";
            }
            else {
                if(TradingTimeUtils.isTreadingDayV1(holidays)) {
                    if(TradingTimeUtils.isWaitOpen(holidays)) {
                        status = "未开盘";
                    }
                    else {
                        status =  "已收盘";
                    }
                }
                else {
                    status =  "已收盘";
                }
            }
        }
        return status;
    }

    public static String genereateState(String holidays) {
        if (StringUtils.isEmpty(holidays)) {
            return "未知";
        }
        String status;
        if(TradingTimeUtils.isTreadingTimeV1(holidays)) {
            status = "交易中";
        }
        else {
            if(TradingTimeUtils.isTreadingDayV1(holidays)) {
                if(TradingTimeUtils.isWaitOpen(holidays)) {
                    status = "未开盘";
                }
                else {
                    status =  "已收盘";
                }
            }
            else {
                status =  "已收盘";
            }
        }
        return status;
    }

    public static String genereateBlockDetailState(String holidays) {
        if (StringUtils.isEmpty(holidays)) {
            return "未知";
        }
        String status;
        if(TradingTimeUtils.isTreadingTimeV1(holidays)) {
            status = "交易中 "+ LocalDateUtils.format(LocalDateTime.now(), LocalDateUtils.formatterDD21);
        }
        else {
            if(TradingTimeUtils.isTreadingDayV1(holidays)) {
                if(TradingTimeUtils.isWaitOpen(holidays)) {
                    status = "未开盘 "+ LocalDateUtils.format(LocalDateTime.now(), LocalDateUtils.formatterDD21);
                }
                else {
                    status =  "已收盘 "+ LocalDateUtils.format(LocalDateTime.now(), LocalDateUtils.formatterDD22) +" 15:00:00";
                }
            }
            else {
                LocalDate localDate = TradingTimeUtils.getPreTradeDay(LocalDate.now(), holidays);
                status = "已收盘 " + LocalDateUtils.format(localDate, LocalDateUtils.formatterDD22) +" 15:00:00";
            }
        }
        return status;
    }
}
