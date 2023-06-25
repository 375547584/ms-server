package com.shenhai.tech.market.project.strategy.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.shenhai.tech.market.common.constant.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KLineEnum implements BaseEnum {
    Min1(1, "min1"),
    Min5(2, "min5"),
    Min15(3, "min15"),
    Min30(4, "min30"),
    Min60(5, "min60"),
    Day(6, "day"),
    Week(7, "week"),
    Month(8, "month"),

    Season(9, "season"),

    HalfYear(10, "halfyear"),

    Year(11, "year");

    @EnumValue
    public final int code;
    public final String description;
}
