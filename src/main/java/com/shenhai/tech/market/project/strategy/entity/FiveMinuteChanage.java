package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FiveMinuteChanage {

    private String code;//股票代码

    private String date;//交易日期
    private String time;//交易时间 10:50:30

    private BigDecimal price;//最新价
    private BigDecimal avprice;//均价股价

    private BigDecimal increase;//涨跌幅
    private BigDecimal risefall;//涨跌
    private BigDecimal amplitude;//涨跌"
    private BigDecimal volratio;//量比
    private BigDecimal bookrate;//委比
    private BigDecimal bookdiffer;//委差

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

    private Long vol;//成交量
    private BigDecimal amount;//成交额
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