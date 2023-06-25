package com.shenhai.tech.market.project.strategy.zlhq.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ZLRTKLine {
    //时间 925/1025
    private String time;
    // 当前价格
    private BigDecimal price;
    // 均价
    private BigDecimal avPrice;
    //成交量
    private Long vol;
    // 成交额
    private BigDecimal amount;
    // 涨跌幅
    private BigDecimal increase;
    // 涨跌额
    private BigDecimal riseFall;
}
