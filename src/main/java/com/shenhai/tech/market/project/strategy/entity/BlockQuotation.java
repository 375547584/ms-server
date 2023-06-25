package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BlockQuotation {
    /**
     * 板块代码
     */
    private String code;
    /**
     * 板块名称
     */
    private String name;
    /**
     * 板块价格 板块下所有股票新价的平均值
     */
    private BigDecimal price;
    /**
     * 板块涨跌幅:板块下所有股票涨跌幅的平均值
     */
    private BigDecimal increase;
    /**
     * 板块涨跌额 板块下所有股票涨跌额的平均值
     */
    private BigDecimal risefall;
    /**
     * '板块类型 0-区域 1-行业 2-概念'
     */
    private Integer type;
}