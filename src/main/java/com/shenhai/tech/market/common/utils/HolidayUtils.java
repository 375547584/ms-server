package com.shenhai.tech.market.common.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HolidayUtils {
    public static final String LEGAL_HOLIDAY_VALUE = "20220101,20220102,20220103,20220131,20220201,20220202,20220203,20220204,20220205,20220206,20220403,20220404,20220405,20220430,20220501,20220502,20220503,20220504,20220603,20220604,20220605,20220910,20220911,20220912,20221001,20221002,20221003,20221004,20221005,20221006,20221007";
    public static List<LocalDate> parseHolidays(String holidays) {
        if (StringUtil.isBlank(holidays)) {
            holidays = LEGAL_HOLIDAY_VALUE;
        }
        return Arrays.stream(holidays.split(",")).map(date->parse(date)).collect(Collectors.toList());
    }

    public static LocalDate parse(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
