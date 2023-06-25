package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockQuota {
    private String code;//code
    private String name;//name

    private BigDecimal avprice;//均价股价

    private BigDecimal amplitude;//涨跌"
    private BigDecimal volratio;//量比
    private BigDecimal bookrate;//委比
    private BigDecimal bookdiffer;//委差
    private BigDecimal increaseweek1;//1周涨幅
    private BigDecimal increaseweek4;//4周涨幅
    private BigDecimal increaseweek13;//13周涨幅
    private BigDecimal increaseweek26;//26周涨幅
    private BigDecimal increaseweek52;//26周涨幅
    private BigDecimal increasethisyear;//今年以来涨幅

    private BigDecimal exchangeRate;//换手率
    private BigDecimal pe;//市盈率（静） 当前的价格/上一年的EPS
    private BigDecimal pe2;//市盈率（TTM） 当前的价格/滚动12个月的EPS
    private BigDecimal pe3;//市盈率（动） 股票当前价格/预测12个月的eps
    private BigDecimal eps;//每股收益 LYR
    private BigDecimal eps2;//每股收益 TTM
    private BigDecimal eps3;//预测EPS
    private BigDecimal pb;//市净率
    private BigDecimal bv;//每股净资产
    private BigDecimal roe;//ROE净资产收益率
    private BigDecimal salesrevenue;//销售收入
    private BigDecimal netprofit;//净利润

    private Long totaleQuity;//总股本
    private Long folweQuity;//流通股本
    private BigDecimal totaleValue; //总市值
    private BigDecimal folweValue; //流通市值

    private Long volin;//内盘总量
    private Long volout;//外盘总量
    private BigDecimal flowin;//资金流入
    private BigDecimal flowout;//资金流出

    public BigDecimal superin; // 超大单流入
    public BigDecimal superout; // 超大单流出
    public BigDecimal bigin; // 大单流入
    public BigDecimal bigout; // 大单流出
    public BigDecimal midin; // 中单流入
    public BigDecimal midout; // 中单流出
    public BigDecimal smallin; // 小单流入
    public BigDecimal smallout; // 小单流出
}
