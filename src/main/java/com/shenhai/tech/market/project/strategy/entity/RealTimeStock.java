package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RealTimeStock extends BuySell10 {

    private String code;//股票代码

    private String state;//股票状态

    private String date;//交易日期
    private String time;//交易时间 10:50:30

    private BigDecimal price;//最新价
    private BigDecimal increase;//涨跌幅
    private BigDecimal risefall;//涨跌

    private BigDecimal yClose;//昨日收盘价

    private BigDecimal openPrice;//开盘价
    private BigDecimal highPrice;//最高股价
    private BigDecimal lowPrice;//最低股价

    private Long vol;//成交量
    private BigDecimal amount;//成交额

    private BigDecimal fallStopPrice;//跌停价
    private BigDecimal riseStopPrice;//涨停价
}
