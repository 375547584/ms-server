package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 板块股票
 */
@Data
public class Stock4B extends BlockStock {
    /**
     * 证券代码
     */
    private String symbol;
    /**
     * 证券代码
     */
    private String name;
    /**
     * 最新价
     */
    private BigDecimal price;
    /**
     * 涨跌幅
     */
    private BigDecimal increase;
    /**
     * 涨跌
     */
    private BigDecimal risefall;
}