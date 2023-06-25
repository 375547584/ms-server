package com.shenhai.tech.market.project.strategy.zlhq.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockVO {
    @ApiModelProperty(value = "股票代码", example = "600036.sh")
    private String symbol;
    @ApiModelProperty(value = "股票代码", example = "600036")
    private String code;
    @ApiModelProperty(value = "股票名称")
    private String name;
    @ApiModelProperty(value = "所属板块(SH,SZ)")
    private String block;
    @ApiModelProperty(value = "股票状态", example = "未开盘/交易中/停盘中")
    private String state;

    @ApiModelProperty(value = "交易日期", example = "2022-09-07")
    private String date;
    @ApiModelProperty(value = "交易时间", example = "10:50:30")
    private String time;
    @ApiModelProperty(value = "小数位数", example = "2")
    private Integer decimal;

    @ApiModelProperty(value = "开盘价", example = "0.23")
    private BigDecimal open;
    @ApiModelProperty(value = "昨日收盘价", example = "61.55")
    private BigDecimal yclose;
    @ApiModelProperty(value = "最新价")
    private BigDecimal price;
    @ApiModelProperty(value = "最高股价", example = "61.55")
    private BigDecimal high;
    @ApiModelProperty(value = "最低股价", example = "61.55")
    private BigDecimal low;
    @ApiModelProperty(value = "均价股价", example = "61.55")
    private BigDecimal avprice;

    @ApiModelProperty(value = "成交量")
    private Long vol;
    @ApiModelProperty(value = "成交额")
    private BigDecimal amount;
    @ApiModelProperty(value = "内盘总量")
    private Long volin;
    @ApiModelProperty(value = "外盘总量")
    private Long volout;
    @ApiModelProperty(value = "资金流入")
    private BigDecimal flowin;
    @ApiModelProperty(value = "资金流出")
    private BigDecimal flowout;

    @ApiModelProperty(value = "涨跌幅")
    private BigDecimal increase;
    @ApiModelProperty(value = "涨跌")
    private BigDecimal risefall;
    @ApiModelProperty(value = "振幅", example = "13.18")
    private BigDecimal amplitude;
    @ApiModelProperty(value = "量比")
    private BigDecimal volratio;
    @ApiModelProperty(value = "委比")
    private BigDecimal bookrate;
    @ApiModelProperty(value = "委差")
    private BigDecimal bookdiffer;

    @ApiModelProperty(value = "1周涨幅")
    private BigDecimal increaseweek1;
    @ApiModelProperty(value = "4周涨幅")
    private BigDecimal increaseweek4;
    @ApiModelProperty(value = "13周涨幅")
    private BigDecimal increaseweek13;
    @ApiModelProperty(value = "26周涨幅")
    private BigDecimal increaseweek26;
    @ApiModelProperty(value = "52周涨幅")
    private BigDecimal increaseweek52;
    @ApiModelProperty(value = "今年以来涨幅")
    private BigDecimal increasethisyear;

    @ApiModelProperty(value = "上市日期")
    private String firstday;

    @ApiModelProperty(value = "换手率", example = "4.14")
    private BigDecimal exchangeRate;
    @ApiModelProperty(value = "市盈率（静） 当前的价格/上一年的EPS")
    private BigDecimal pe;
    @ApiModelProperty(value = "市盈率（TTM） 当前的价格/滚动12个月的EPS")
    private BigDecimal pe2;
    @ApiModelProperty(value = "市盈率（动） 股票当前价格/预测12个月的eps")
    private BigDecimal pe3;
    @ApiModelProperty("每股收益 LYR")
    private BigDecimal eps;
    @ApiModelProperty("每股收益 TTM")
    private BigDecimal eps2;
    @ApiModelProperty("预测EPS")
    private BigDecimal eps3;
    @ApiModelProperty(value = "市净率")
    private BigDecimal pb;
    @ApiModelProperty(value = "每股净资产")
    private BigDecimal bv;
    @ApiModelProperty(value = "ROE净资产收益率")
    private BigDecimal roe;
    @ApiModelProperty(value = "销售收入")
    private BigDecimal salesrevenue;
    @ApiModelProperty(value = "净利润")
    private BigDecimal netprofit;

    @ApiModelProperty(value = "是否指数")
    private Integer isindex;

    @ApiModelProperty(value = "停牌股票数量")
    private Integer stop;
    @ApiModelProperty(value = "涨停股票数量")
    private Integer up;
    @ApiModelProperty(value = "跌停股票数量")
    private Integer down;
    @ApiModelProperty(value = "没涨没跌的股票数量")
    private Integer unchanged;

    @ApiModelProperty(value = "跌停价", example = "55.40")
    private BigDecimal fallStopPrice;
    @ApiModelProperty(value = "涨停价", example = "67.71")
    private BigDecimal riseStopPrice;

    @ApiModelProperty(value = "总股本")
    private Long totaleQuity;
    @ApiModelProperty(value = "流通股本")
    private Long folweQuity;
    @ApiModelProperty(value = "总市值")
    private BigDecimal totaleValue;
    @ApiModelProperty(value = "流通市值")
    private BigDecimal folweValue;


    @ApiModelProperty(value = "买价一")
    private BigDecimal buypx1 = BigDecimal.ZERO;
    @ApiModelProperty(value = "买价二")
    private BigDecimal buypx2 = BigDecimal.ZERO;
    @ApiModelProperty(value = "买价三")
    private BigDecimal buypx3 = BigDecimal.ZERO;
    @ApiModelProperty(value = "买价四")
    private BigDecimal buypx4 = BigDecimal.ZERO;
    @ApiModelProperty(value = "买价五")
    private BigDecimal buypx5 = BigDecimal.ZERO;

    @ApiModelProperty(value = "买量一")
    private Long buyvol1 = 0L;
    @ApiModelProperty(value = "买量二")
    private Long buyvol2 = 0L;
    @ApiModelProperty(value = "买量三")
    private Long buyvol3 = 0L;
    @ApiModelProperty(value = "买量四")
    private Long buyvol4 = 0L;
    @ApiModelProperty(value = "买量五")
    private Long buyvol5 = 0L;

    @ApiModelProperty(value = "卖价一")
    private BigDecimal sellpx1 = BigDecimal.ZERO;
    @ApiModelProperty(value = "卖价二")
    private BigDecimal sellpx2 = BigDecimal.ZERO;
    @ApiModelProperty(value = "卖价三")
    private BigDecimal sellpx3 = BigDecimal.ZERO;
    @ApiModelProperty(value = "卖价四")
    private BigDecimal sellpx4 = BigDecimal.ZERO;
    @ApiModelProperty(value = "卖价五")
    private BigDecimal sellpx5 = BigDecimal.ZERO;

    @ApiModelProperty(value = "卖量一")
    private Long sellvol1 = 0L;
    @ApiModelProperty(value = "卖量二")
    private Long sellvol2 = 0L;
    @ApiModelProperty(value = "卖量三")
    private Long sellvol3 = 0L;
    @ApiModelProperty(value = "卖量四")
    private Long sellvol4 = 0L;
    @ApiModelProperty(value = "卖量五")
    private Long sellvol5 = 0L;
}