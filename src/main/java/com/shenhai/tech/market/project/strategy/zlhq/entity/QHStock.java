package com.shenhai.tech.market.project.strategy.zlhq.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class QHStock {
    private String symbol;  //证券代码
    private String name;  //证券简称
    private String date;  //交易日期
    private String time;  //交易时间

    private Integer decimal;  //小数位数
    private BigDecimal open;  //开盘价
    private BigDecimal yclose;  //前收盘价
    private BigDecimal price;  //最新价
    private BigDecimal high;  //最高价
    private BigDecimal low;  //最低价
    private BigDecimal avprice;  //均价
    private Long vol;  //成交量"
    private BigDecimal amount;  //成交额
    private Long volin;  //内盘总量
    private Long volout;  //外盘总量
    private BigDecimal flowin;  //资金流入
    private BigDecimal flowout;  //资金流出

    private BigDecimal buypx1;  //买价一
    private BigDecimal buypx2;  //买价二
    private BigDecimal buypx3;  //买价三
    private BigDecimal buypx4;  //买价四
    private BigDecimal buypx5;  //买价五

    private Long buyvol1;  //买量一
    private Long buyvol2;  //买量二
    private Long buyvol3;  //买量三
    private Long buyvol4;  //买量四
    private Long buyvol5;  //买量五

    private BigDecimal sellpx1;  //卖价一
    private BigDecimal sellpx2;  //卖价二
    private BigDecimal sellpx3;  //卖价三
    private BigDecimal sellpx4;  //卖价四
    private BigDecimal sellpx5;  //卖价五

    private Long sellvol1;  //卖量一
    private Long sellvol2;  //卖量二
    private Long sellvol3;  //卖量三
    private Long sellvol4;  //卖量四
    private Long sellvol5;  //卖量五


    private BigDecimal risefall;  //涨跌
    private BigDecimal increase;  //涨幅
    private BigDecimal bookrate;  //委比
    private BigDecimal bookdiffer;  //委差
    private BigDecimal amplitude;  //振幅
    private BigDecimal volratio;  //量比


    private BigDecimal increaseweek1;  //1周涨幅
    private BigDecimal increaseweek4;  //4周涨幅
    private BigDecimal increaseweek13;  //13周涨幅
    private BigDecimal increaseweek26;  //26周涨幅
    private BigDecimal increaseweek52;  //52周涨幅
    private BigDecimal increasethisyear;  //今年以来涨幅

    private String firstday;  //上市日期

    private BigDecimal exchangerate;  //换手率
    private BigDecimal eps;  //上年度EPS
    private BigDecimal eps2;  //滚动12个月EPS
    private BigDecimal eps3;  //预测EPS
    private BigDecimal pe;  //上年度PE
    private BigDecimal pe2;  //滚动PE
    private BigDecimal pe3;  //预测PE
    private BigDecimal bv;  //每股净资产
    private BigDecimal pb;  //PB市净率
    private BigDecimal roe;  //ROE净资产收益率

    private BigDecimal salesrevenue;  //销售收入
    private BigDecimal netprofit;  //净利润
    private Integer isindex = 0;  //是否指数
    private Integer advance;  //上涨家数
    private Integer decline;  //下跌家数
    private Integer stop;  //停牌家数
    private Integer unchanged;  //平盘家数

    private Integer upstock;  //领涨个股
    private Integer dnstock;  //领跌个股

    private List<ZLRTKLine> minute;  //分钟走势

    private BigDecimal uplimit;  //涨停价格
    private BigDecimal dnlimit;  //跌停价格

    private Long totalequity;  //总股本
    private Long folwequity;  //流通股本
    private BigDecimal marketvalue;  //总市值
    private BigDecimal flowmarketvalue;  //流通市值

    private BigDecimal superin;                    //超大单流入
    private BigDecimal superout;                    //超大单流出
    private BigDecimal bigin;                    //大单流入
    private BigDecimal bigout;                    //大单流出
    private BigDecimal midin;                    //中单流入
    private BigDecimal midout;                    //中单流出
    private BigDecimal smallin;                    //小单流入
    private BigDecimal smallout;                    //小单流出

    private List<BlockItem> region;  //所属地区
    private List<BlockItem> industry;  //所属行业
    private List<BlockItem> concept;  //所属概念板块



    private String companyname;                //公司全称
    private String companynameen;                //英文名称
    private String ename;                    //英文简称
    private String registeredaddress;                //注册地址
    private String businessaddress;                //办公地址
    private String zipcode;                    //邮政编码
    private String homepage;                //公司主页
    private String email;                        //公司电子邮箱
    private String companyphone;                //公司电话
    private String companyfax;                    //公司传真
    private String chairman;                    //董事长
    private String legalrepresentative;            //法人代表
    private String ceo;                        //总经理
    private String boardsecretary;                //董事会秘书
    private String boardsecretaryphone;            //董事会秘书电话
    private String boardsecretaryfax;                //董事会秘书传真
    private String boardsecretaryemail;            //董事会秘书邮箱
    private String sar;                        //证券代表
    private String sarphone;                    //证券代表电话
    private String sarfax;                        //证券代表传真
    private String saremail;                    //证券代表邮箱
    private BigDecimal registeredcapital;                //注册资金
    private String businesslicense;                //营业执照
    private String ntrn;                        //国税登记号
    private String ltrn;                        //地税登记号
    private String idwebsite;                    //信息披露网站
    private String idmedia;                //信息披露媒体
    private String companyhistory;                //公司沿革
    private String mainbusiness;            //主营业务
    private String businessscope;                //经营范围

    public Long folwequitya ; // 流通 A 股
    public Long folwequityb; // 流通 B 股
    public Long folwequityh; // 流通 H 股
    public Long folwequityo; // 其他流通股
    public Long uncirculatedquity; // 未流通股份
    public Long restrictedquity; // 流通受限股本
    public Long managerialownership; // 高管持股
    public Long stateholding; // 国家持股
    public Long stateownedlegalholding; // 国有法人持股
    public Long domesticlegalholding; // 境内法人持股
    public Long overseaslegalholding; // 境外法人持股
    public Long preferredstock; // 优先股

    public List<StockHolderItem> stockholder1;
    public List<StockHolderItem> stockholder2;
    public List<StockHolderItem> stockholder3;
    public List<StockHolderItem> stockholder4;
    public List<StockHolderItem> stockholder5;
    public List<StockHolderItem> stockholder6;
    public List<StockHolderItem> stockholder7;
    public List<StockHolderItem> stockholder8;
    public List<StockHolderItem> stockholder9;
    public List<StockHolderItem> stockholder10;

    public List<FolwStockHolderItem> folwstockholder1;
    public List<FolwStockHolderItem> folwstockholder2;
    public List<FolwStockHolderItem> folwstockholder3;
    public List<FolwStockHolderItem> folwstockholder4;
    public List<FolwStockHolderItem> folwstockholder5;
    public List<FolwStockHolderItem> folwstockholder6;
    public List<FolwStockHolderItem> folwstockholder7;
    public List<FolwStockHolderItem> folwstockholder8;
    public List<FolwStockHolderItem> folwstockholder9;
    public List<FolwStockHolderItem> folwstockholder10;

    public String rptdate; // 报告期
    public BigDecimal totalassets; // 总资产
    public BigDecimal ownershipinterest; // 所有者权益
    public BigDecimal floatingassets; // 流动资产
    public BigDecimal monetaryfund; // 货币资金
    public BigDecimal accountsreceivable; // 应收账款
    public BigDecimal goodsinstock; // 存货
    public BigDecimal currentliabilities; // 流动负债
    public BigDecimal noncurrentliabilities; // 非流动负债
    public BigDecimal totalliabilities; // 负债合计
    public BigDecimal financialexpenses; // 财务费用
    public BigDecimal operatingcashflow; // 经营性现金流量
    public BigDecimal grossrevenue; // 营业总收入
    public BigDecimal grossprofit; // 主营业务利润
    public BigDecimal threeexpenses; // 三项费用
    public BigDecimal investmentincome; // 投资收益
    public BigDecimal operatingprofit; // 营业利润
    public BigDecimal finetprofit; // 净利润
    public BigDecimal finetprofit2; // 归母净利润
    public BigDecimal finetprofit3; // 扣非净利润
    public BigDecimal fieps; // 基本每股收益
    public BigDecimal fieps2; // 扣非每股收益
    public BigDecimal finaps; // 每股净资产
    public BigDecimal firoe; // 加权平均净资产收益率
    public Integer cwip; // 在建工程
    public BigDecimal depreciation; // 累计折旧
    public BigDecimal minorityinterest; // 少数股东权益
    public BigDecimal exchangeloss; // 汇兑损益
    public BigDecimal baddebt; // 坏账汇总
    public BigDecimal fixedassets; // 固定资产
    public BigDecimal depreciation2; // 当期折旧
    public BigDecimal interestexpenses; // 利息费用
    public BigDecimal interestincome; // 利息收入
}
