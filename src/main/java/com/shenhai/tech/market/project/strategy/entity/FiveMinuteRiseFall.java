package com.shenhai.tech.market.project.strategy.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 每5分钟一条数据
 */
@Data
public class FiveMinuteRiseFall {
    @ApiModelProperty(value = "股票代码", example = "600036")
    private String code;
    @ApiModelProperty(value = "股票名称")
    private String name;
    @ApiModelProperty(value = "所属板块(SH,SZ)")
    private String block;
    @ApiModelProperty(value = "差价:5分钟的价格插")
    private BigDecimal price;
    @ApiModelProperty(value = "涨跌幅:5分钟的涨跌幅差")
    private BigDecimal increase;
    @ApiModelProperty(value = "涨跌额:5分钟的涨跌额差")
    private BigDecimal risefall;
}
