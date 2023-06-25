package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Suspension {
    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 停牌开始时间
     */
    private LocalDate startDate;
}
