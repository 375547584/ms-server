package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Index {
    private String symbol;//股票代码
    private String code;//股票代码
    private String name;//股票名称
    private String block;//所属板块(SH,SZ)

    private String state;//股票状态

    private String date;//交易日期
    private String time;//交易时间 10:50:30


    private BigDecimal price;//最新价
    private BigDecimal increase;//涨跌幅
    private BigDecimal risefall;//涨跌

    private BigDecimal openPrice;//开盘价
    private BigDecimal yClose;//昨日收盘价
    private BigDecimal highPrice;//最高股价
    private BigDecimal lowPrice;//最低股价
    private BigDecimal avprice;//均价股价

    private Long vol;//成交量
    private BigDecimal amount;//成交额

    private BigDecimal totaleValue; //总市值
    private BigDecimal pe;//市盈率（静）


    private Integer isindex = 0;//是否指数

    private Integer stop = 0;//停牌股票数量
    private Integer up = 0;//上涨股票数量
    private Integer down = 0;//下跌股票数量
    private Integer unchanged = 0;//平盘的股票数量


}