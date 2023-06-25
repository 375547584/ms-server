package com.shenhai.tech.market.project.cache;

import com.shenhai.tech.market.common.exception.BusinessException;
import com.shenhai.tech.market.common.utils.StringUtils;

public class ConstantCache {
    private static String holidays;

    private static String realtime;

    public static String getHolidays() {
        return holidays;
    }

    public static void setHolidays(String holidays) {
        if(StringUtils.isEmpty(holidays)) {
            throw new BusinessException(20123,String.format("节假日日期为空 %s", holidays));
        }
        ConstantCache.holidays = holidays;
    }

    public static String getRealtime() {
        return realtime;
    }

    public static void setRealtime(String realtime) {
        if(StringUtils.isEmpty(realtime)) {
            return;
        }
        if(StockSource.RT_QTS.equals(realtime)) {
            ConstantCache.realtime = realtime;
        }
        else if(StockSource.RT_ZLQH.equals(realtime)) {
            ConstantCache.realtime = realtime;
        }
        else if(StockSource.RT_SELF.equals(realtime)) {
            ConstantCache.realtime = realtime;
        }
        else {
            throw new BusinessException(20124,String.format("配置不正确 %s", realtime));
        }
    }
}
