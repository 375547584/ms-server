package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DelistStock {
    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 退市时间
     */
    private LocalDate delistDate;
}
