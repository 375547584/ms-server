package com.shenhai.tech.market.project.strategy.zlhq.entity;

import com.shenhai.tech.market.project.strategy.entity.Stock;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 板块股票
 */
@Data
public class Block {
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

    /**
     * 最新价
     */
    private BigDecimal totalPrice;
    /**
     * 涨跌幅
     */
    private BigDecimal totalIncrease;
    /**
     * 涨跌
     */
    private BigDecimal totalRisefall;

    /**
     * 下级人数
     */
    private Integer subCount = 0;

    /**
     * 板块下涨幅最高的股票
     */
    private Stock bestStock;

    /**
     * 板块下上涨盘票数
     */
    private Integer up = 0;

    /**
     * 板块下下跌盘票数
     */
    private Integer down = 0;

    /**
     * 板块下平盘票数
     */
    private Integer unchanage = 0;
}