package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

@Data
public class StockCode {
    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 股票名称
     */
    private String stockName;
    /**
     * 板块
     */
    private String stockBlock;
    /**
     * 股票简拼
     */
    private String stockJaneSpell;
}
