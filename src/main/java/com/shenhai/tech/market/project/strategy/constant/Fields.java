package com.shenhai.tech.market.project.strategy.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 股票常量信息
 *
 * @author capital
 */
public class Fields {

    public static String type = "type";
    public static String buy = "buy";
    public static String sell = "sell";
    public static String deal = "deal";

    public static String indextop = "indextop";
    public static String risefallspeed = "risefallspeed";
    public static String flowday = "flowday";
    public static String flowday3 = "flowday3";
    public static String flowday5 = "flowday5";
    public static String flowday10 = "flowday10";
    /************indextop指数排行数据返回字段*****************/
    public static String up = "up";
    public static String down = "down";
    public static String bs = "bs";
    public static String limitprice = "limitprice";
    public static String max = "max";
    public static String min = "min";
    public static String close = "close";
    public static String finance = "finance";
    public static String persearning = "persearning";
    public static String woewa = "woewa";
    public static String company = "company";
    public static String releasedate = "releasedate";
    public static String startdate = "startdate";
    public static String report = "report";
    public static String title = "title";
    public static String url = "url";
    public static String registerdate = "registerdate";
    public static String dividenddate = "dividenddate";
    public static String payabledate = "payabledate";
    public static String stock = "stock";
    public static String stockday = "stockday";
    public static String dividend = "dividend";
    public static String plan = "plan";
    public static String code = "code";
    public static String npersearning = "npersearning";
    public static String nprofit = "nprofit";
    public static String profityoy = "profityoy";
    public static String orevenues = "orevenues";
    public static String oprofit = "oprofit";
    public static String peruprofit = "peruprofit";
    public static String moprofit = "moprofit";
    public static String deListing = "deListing";
    public static String avgvol5 = "avgvol5";
    public static String company_releasedate = "company.releasedate";
    public static String finance_eps = "finance.eps";
    public static String finance_persearning = "finance.persearning";
    public static String finance_woewa = "finance.woewa";
    public static String mainin = "mainin";
    public static String mainout = "mainout";
    public static String mainnetin = "mainnetin";
    public static String baddebts = "baddebts";
    public static String lossexchange = "lossexchange";
    public static String accdepreciation = "accdepreciation";
    public static String inprocess = "inprocess";
    public static String percreserve = "percreserve";
    public static String perccfo = "perccfo";
    public static String ccfo = "ccfo";
    public static String ncurrentliabilities = "ncurrentliabilities";
    public static String alratio = "alratio";
    public static String expenses3 = "expenses3";
    public static String inventory = "inventory";
    public static String monetaryfunds = "monetaryfunds";
    public static String currentassets = "currentassets";
    public static String areceivable = "areceivable";
    public static String totalownersequity = "totalownersequity";
    public static String pernetasset = "pernetasset";
    public static String financialcost = "financialcost";
    public static String pcnprofit = "pcnprofit";
    public static String nnetprofit = "nnetprofit";
    public static String mholderprofit = "mholderprofit";
    public static String grossmargin = "grossmargin";


/******************************************************************************************************************************************************************************/
/**                            ZLHQ数据字段                                                                                                                                    **/
    /******************************************************************************************************************************************************************************/

    public static String symbol = "symbol"; //证券代码
    public static String name = "name"; // 证券简称
    public static String date = "date"; // 交易日期
    public static String time = "time"; // 交易时间
    public static String decimal = "decimal"; // 小数位数
    public static String open = "open"; // 开盘价
    public static String yclose = "yclose"; // 前收盘价
    public static String price = "price"; // 最新价
    public static String high = "high"; // 最高价
    public static String low = "low"; // 最低价
    public static String avprice = "avprice"; // 均价
    public static String vol = "vol"; // 成交量
    public static String amount = "amount"; // 成交额
    public static String volin = "volin"; // 内盘总量
    public static String volout = "volout"; // 外盘总量
    public static String flowin = "flowin"; // 资金流入
    public static String flowout = "flowout"; // 资金流出
    public static String buypx1 = "buypx1";
    public static String buypx2 = "buypx2";
    public static String buypx3 = "buypx3";
    public static String buypx4 = "buypx4";
    public static String buypx5 = "buypx5";

    public static String buyvol1 = "buyvol1";
    public static String buyvol2 = "buyvol2";
    public static String buyvol3 = "buyvol3";
    public static String buyvol4 = "buyvol4";
    public static String buyvol5 = "buyvol5";

    public static String sellpx1 = "sellpx1";
    public static String sellpx2 = "sellpx2";
    public static String sellpx3 = "sellpx3";
    public static String sellpx4 = "sellpx4";
    public static String sellpx5 = "sellpx5";

    public static String sellvol1 = "sellvol1";
    public static String sellvol2 = "sellvol2";
    public static String sellvol3 = "sellvol3";
    public static String sellvol4 = "sellvol4";
    public static String sellvol5 = "sellvol5";


    public static String increase = "increase"; //涨跌幅
    public static String risefall = "risefall"; //涨跌额，是价格变动差值
    public static String bookrate = "bookrate"; //委比
    public static String bookdiffer = "bookdiffer"; // 委差
    public static String amplitude = "amplitude"; // 振幅
    public static String volratio = "volratio"; // 量比

    public static String increaseweek1 = "increaseweek1"; //  1 周涨幅
    public static String increaseweek4 = "increaseweek4"; //  4 周涨幅
    public static String increaseweek13 = "increaseweek13"; //  13 周涨幅
    public static String increaseweek26 = "increaseweek26"; //  26 周涨幅
    public static String increaseweek52 = "increaseweek52"; //  52 周涨幅
    public static String increasethisyear = "increasethisyear"; //  今年以来涨幅
    public static String firstday = "firstday"; //上市日期

    public static String exchangerate = "exchangerate"; // 换手率
    public static String eps = "eps"; // 上年度 EPS（每股收益 LYR）
    public static String eps2 = "eps2"; // 滚动 12 个月 EPS（每股收益 TTM）
    public static String eps3 = "eps3"; // 预测 EPS
    public static String pe = "pe"; // 上年度 PE
    public static String pe2 = "pe2"; // 滚动 PE
    public static String pe3 = "pe3"; // 预测 PE
    public static String bv = "bv"; // 每股净资产
    public static String pb = "pb"; // 市净率 PB
    public static String roe = "roe"; // 净资产收益率 ROE
    public static String salesrevenue = "salesrevenue"; // 销售收入
    public static String netprofit = "netprofit"; // 净利润
    public static String isindex = "isindex"; // 是否指数
    public static String advance = "advance"; // 上涨家数
    public static String decline = "decline"; // 下跌家数

    public static String stop = "stop";	//停牌家数
    public static String unchanged = "unchanged"; //平盘家数
    public static String upstock = "upstock"; //领涨个股(指数)
    public static String dnstock = "dnstock"; //领跌个股(指数)

    public static String uplimit = "uplimit"; // 涨停价格
    public static String dnlimit = "dnlimit"; // 跌停价格
    public static String minute = "minute"; //分钟走势

    public static String totalequity = "totalequity"; // 总股本
    public static String folwequity = "folwequity"; // 流通股本
    public static String marketvalue = "marketvalue"; // 总市值
    public static String flowmarketvalue = "flowmarketvalue"; // 流通市值

    public static String superin = "superin"; // 超大单流入
    public static String superout = "superout"; // 超大单流出
    public static String bigin = "bigin"; // 大单流入
    public static String bigout = "bigout"; // 大单流出
    public static String midin = "midin"; // 中单流入
    public static String midout = "midout"; // 中单流出
    public static String smallin = "smallin"; // 小单流入
    public static String smallout = "smallout"; // 小单流出



    public static String region = "region"; // 所属地区 返回数据格式：[板块 ID,板块名称,板块所有个股数量]
    public static String industry = "industry"; // 所属行业  返回数据格式：[板块 ID,板块名称,板块所有个股数量]
    public static String concept = "concept"; // 所属概念板块  返回数据格式：[板块 ID,板块名称,板块所有个股数量]

    public static String companyname = "companyname"; // 公司全称
    public static String companynameen = "companynameen"; // 英文名称
    public static String ename = "ename"; // 英文简称
    public static String registeredaddress = "registeredaddress"; // 注册地址
    public static String businessaddress = "businessaddress"; // 办公地址
    public static String zipcode = "zipcode"; // 邮政编码
    public static String homepage = "homepage"; // 公司主页
    public static String email = "email"; // 公司电子邮箱
    public static String companyphone = "companyphone"; // 公司电话
    public static String companyfax = "companyfax"; // 公司传真
    public static String chairman = "chairman"; // 董事长
    public static String legalrepresentative = "legalrepresentative"; // 法人代表
    public static String ceo = "ceo"; // 总经理
    public static String boardsecretary = "boardsecretary"; // 董事会秘书
    public static String boardsecretaryphone = "boardsecretaryphone"; // 董事会秘书电话
    public static String boardsecretaryfax = "boardsecretaryfax"; // 董事会秘书传真
    public static String boardsecretaryemail = "boardsecretaryemail"; // 董事会秘书邮箱
    public static String sar = "sar"; // 证券代表
    public static String sarphone = "sarphone"; // 证券代表电话
    public static String sarfax = "sarfax"; // 证券代表传真
    public static String saremail = "saremail"; // 证券代表邮箱
    public static String registeredcapital = "registeredcapital"; // 注册资金
    public static String businesslicense = "businesslicense"; // 营业执照
    public static String ntrn = "ntrn"; // 国税登记号
    public static String ltrn = "ltrn"; // 地税登记号
    public static String idwebsite = "idwebsite"; // 信息披露网站
    public static String idmedia = "idmedia"; // 信息披露媒体
    public static String companyhistory = "companyhistory"; // 公司沿革
    public static String mainbusiness = "mainbusiness"; // 主营业务
    public static String businessscope = "businessscope"; // 经营范围


    public static String folwequitya = "folwequitya"; // 流通 A 股
    public static String folwequityb = "folwequityb"; // 流通 B 股
    public static String folwequityh = "folwequityh"; // 流通 H 股
    public static String folwequityo = "folwequityo"; // 其他流通股
    public static String uncirculatedquity = "uncirculatedquity"; // 未流通股份
    public static String restrictedquity = "restrictedquity"; // 流通受限股本
    public static String managerialownership = "managerialownership"; // 高管持股
    public static String stateholding = "stateholding"; // 国家持股
    public static String stateownedlegalholding = "stateownedlegalholding"; // 国有法人持股
    public static String domesticlegalholding = "domesticlegalholding"; // 境内法人持股
    public static String overseaslegalholding = "overseaslegalholding"; // 境外法人持股
    public static String preferredstock = "preferredstock"; // 优先股


    //    [
//            20220930,
//            "中国平安保险(集团)股份有限公司－集团本级－自有资金",
//            9618540236,
//            49.56,
//            0,
//            0.00,
//            "保险公司",
//            "流通A股"
//     ]
    public static String stockholder1 = "stockholder1"; // 第一大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder2 = "stockholder2"; // 第二大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder3 = "stockholder3"; // 第三大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder4 = "stockholder4"; // 第四大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder5 = "stockholder5"; // 第五大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder6 = "stockholder6"; // 第六大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder7 = "stockholder7"; // 第七大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder8 = "stockholder8"; // 第八大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder9 = "stockholder9"; // 第九大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]
    public static String stockholder10 = "stockholder10"; // 第十大股东 返回数据格式：[公告日期,股东名称,持股数量,占股比,本期增减股数,本期增减幅度,股东类型,股份性质]

    public static String folwstockholder1 = "folwstockholder1"; // 第一大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder2 = "folwstockholder2"; // 第二大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder3 = "folwstockholder3"; // 第三大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder4 = "folwstockholder4"; // 第四大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder5 = "folwstockholder5"; // 第五大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder6 = "folwstockholder6"; // 第六大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder7 = "folwstockholder7"; // 第七大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder8 = "folwstockholder8"; // 第八大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder9 = "folwstockholder9"; // 第九大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]
    public static String folwstockholder10 = "folwstockholder10"; // 第十大流通股东 返回数据格式：[公告日期,股东名称,持股数量,占总股本比,占流通股本比,本期增减股数,股东类型,股份性质]


    ///主要财务指标 当有参数"rpttype":1 时，取上个年度的指标数据 否则取上个报告期的指标数据
    // rpttype":1 或者 20220930
    public static String rptdate = "rptdate"; // 报告期
    public static String totalassets = "totalassets"; // 总资产
    public static String ownershipinterest = "ownershipinterest"; // 所有者权益
    public static String floatingassets = "floatingassets"; // 流动资产
    public static String monetaryfund = "monetaryfund"; // 货币资金
    public static String accountsreceivable = "accountsreceivable"; // 应收账款
    public static String goodsinstock = "goodsinstock"; // 存货
    public static String currentliabilities = "currentliabilities"; // 流动负债
    public static String noncurrentliabilities = "noncurrentliabilities"; // 非流动负债
    public static String totalliabilities = "totalliabilities"; // 负债合计
    public static String financialexpenses = "financialexpenses"; // 财务费用
    public static String operatingcashflow = "operatingcashflow"; // 经营性现金流量
    public static String grossrevenue = "grossrevenue"; // 营业总收入
    public static String grossprofit = "grossprofit"; // 主营业务利润
    public static String threeexpenses = "threeexpenses"; // 三项费用
    public static String investmentincome = "investmentincome"; // 投资收益
    public static String operatingprofit = "operatingprofit"; // 营业利润
    public static String finetprofit = "finetprofit"; // 净利润
    public static String finetprofit2 = "finetprofit2"; // 归母净利润
    public static String finetprofit3 = "finetprofit3"; // 扣非净利润
    public static String fieps = "fieps"; // 基本每股收益
    public static String fieps2 = "fieps2"; // 扣非每股收益
    public static String finaps = "finaps"; // 每股净资产
    public static String firoe = "firoe"; // 加权平均净资产收益率
    public static String cwip = "cwip"; // 在建工程
    public static String depreciation = "depreciation"; // 累计折旧
    public static String minorityinterest = "minorityinterest"; // 少数股东权益
    public static String exchangeloss = "exchangeloss"; // 汇兑损益
    public static String baddebt = "baddebt"; // 坏账汇总
    public static String fixedassets = "fixedassets"; // 固定资产
    public static String depreciation2 = "depreciation2"; // 当期折旧
    public static String interestexpenses = "interestexpenses"; // 利息费用
    public static String interestincome = "interestincome"; // 利息收入


    public static String capital = "capital"; // 流通股本



    public static List<String> zlqhMinuteRealTimeKLineFields = Arrays.asList(
            Fields.symbol,
            Fields.name,
            Fields.date,
            Fields.time,
            Fields.open,
            Fields.high,
            Fields.low,
            Fields.minute
    );


    /**
     * 获取股票信息
     */
    public static List<String> zlqhRealTimeStockFields = Arrays.asList(
            Fields.symbol,
            Fields.name,

            Fields.date,
            Fields.time,

            Fields.increase,
            Fields.risefall,
            Fields.price,
            Fields.high,
            Fields.low,
            Fields.avprice,
            Fields.vol,
            Fields.amount,

            Fields.buypx1,
            Fields.buypx2,
            Fields.buypx3,
            Fields.buypx4,
            Fields.buypx5,

            Fields.buyvol1,
            Fields.buyvol2,
            Fields.buyvol3,
            Fields.buyvol4,
            Fields.buyvol5,

            Fields.sellpx1,
            Fields.sellpx2,
            Fields.sellpx3,
            Fields.sellpx4,
            Fields.sellpx5,

            Fields.sellvol1,
            Fields.sellvol2,
            Fields.sellvol3,
            Fields.sellvol4,
            Fields.sellvol5
    );


    public static List<String> zlqhIndexQuotationFields = Arrays.asList(
            Fields.symbol,

            Fields.date,
            Fields.time,

            Fields.price,
            Fields.increase,
            Fields.risefall,

            Fields.open,
            Fields.yclose,

            Fields.high,
            Fields.low,

            Fields.vol,
            Fields.amount
    );


    public static List<String>  zlqhStockQuotationFields = Arrays.asList(
            Fields.symbol,

            Fields.date,
            Fields.time,

            Fields.price,
            Fields.increase,
            Fields.risefall,

            Fields.open,
            Fields.yclose,

            Fields.high,
            Fields.low,

            Fields.uplimit,
            Fields.dnlimit,

            Fields.vol,
            Fields.amount,

            Fields.buypx1,
            Fields.buypx2,
            Fields.buypx3,
            Fields.buypx4,
            Fields.buypx5,

            Fields.buyvol1,
            Fields.buyvol2,
            Fields.buyvol3,
            Fields.buyvol4,
            Fields.buyvol5,

            Fields.sellpx1,
            Fields.sellpx2,
            Fields.sellpx3,
            Fields.sellpx4,
            Fields.sellpx5,

            Fields.sellvol1,
            Fields.sellvol2,
            Fields.sellvol3,
            Fields.sellvol4,
            Fields.sellvol5
    );

    public static List<String>  zlqhIndexStockFields = Arrays.asList(
            Fields.symbol,
            Fields.name,

            Fields.date,
            Fields.time,
            Fields.decimal,

            Fields.open,
            Fields.yclose,
            Fields.price,
            Fields.high,
            Fields.low,
            Fields.avprice,

            Fields.vol,
            Fields.amount,
            Fields.volin,
            Fields.volout,
            Fields.flowin,
            Fields.flowout,

            Fields.superin,
            Fields.superout,
            Fields.bigin,
            Fields.bigout,
            Fields.midin,
            Fields.midout,
            Fields.smallin,
            Fields.smallout,

            Fields.increase,
            Fields.risefall,
            Fields.amplitude,
            Fields.bookrate,
            Fields.volratio,
            Fields.bookdiffer,

            Fields.increaseweek1,
            Fields.increaseweek4,
            Fields.increaseweek13,
            Fields.increaseweek26,
            Fields.increaseweek52,
            Fields.increasethisyear,

            Fields.firstday,

            Fields.exchangerate,

            Fields.eps,
            Fields.eps2,
            Fields.eps3,
            Fields.pe,
            Fields.pe2,
            Fields.pe3,
            Fields.pb,
            Fields.bv,
            Fields.roe,
            Fields.salesrevenue,
            Fields.netprofit,

            Fields.isindex,
            Fields.uplimit,
            Fields.dnlimit,

            Fields.totalequity,
            Fields.folwequity,
            Fields.marketvalue,
            Fields.flowmarketvalue,

            Fields.advance,
            Fields.decline,
            Fields.stop,
            Fields.unchanged
    );

    /**
     * 获取股票信息
     */
    public static List<String> zlqhStockFields = Arrays.asList(
            Fields.symbol,
            Fields.name,

            Fields.date,
            Fields.time,
            Fields.decimal,

            Fields.open,
            Fields.yclose,
            Fields.price,
            Fields.high,
            Fields.low,
            Fields.avprice,

            Fields.vol,
            Fields.amount,
            Fields.volin,
            Fields.volout,
            Fields.flowin,
            Fields.flowout,

            Fields.superin,
            Fields.superout,
            Fields.bigin,
            Fields.bigout,
            Fields.midin,
            Fields.midout,
            Fields.smallin,
            Fields.smallout,

            Fields.increase,
            Fields.risefall,
            Fields.amplitude,
            Fields.bookrate,
            Fields.volratio,
            Fields.bookdiffer,

            Fields.increaseweek1,
            Fields.increaseweek4,
            Fields.increaseweek13,
            Fields.increaseweek26,
            Fields.increaseweek52,
            Fields.increasethisyear,

            Fields.firstday,

            Fields.exchangerate,

            Fields.eps,
            Fields.eps2,
            Fields.eps3,
            Fields.pe,
            Fields.pe2,
            Fields.pe3,
            Fields.pb,
            Fields.bv,
            Fields.roe,
            Fields.salesrevenue,
            Fields.netprofit,

            Fields.isindex,
            Fields.uplimit,
            Fields.dnlimit,

            Fields.totalequity,
            Fields.folwequity,
            Fields.marketvalue,
            Fields.flowmarketvalue,

            Fields.buypx1,
            Fields.buypx2,
            Fields.buypx3,
            Fields.buypx4,
            Fields.buypx5,

            Fields.buyvol1,
            Fields.buyvol2,
            Fields.buyvol3,
            Fields.buyvol4,
            Fields.buyvol5,

            Fields.sellpx1,
            Fields.sellpx2,
            Fields.sellpx3,
            Fields.sellpx4,
            Fields.sellpx5,

            Fields.sellvol1,
            Fields.sellvol2,
            Fields.sellvol3,
            Fields.sellvol4,
            Fields.sellvol5
    );

    /**
     * 获取股票信息
     */
    public static List<String> stockFields = Arrays.asList(
            Fields.symbol,
            Fields.name,
            Fields.price,
            Fields.open,
            Fields.increase,
            Fields.risefall,
            Fields.limitprice
    );

    public static List<String> zlqhAllblockStockFields = Arrays.asList(
            Fields.symbol,
            Fields.name,
            Fields.region,
            Fields.industry,
            Fields.concept
    );

    public static List<String> kLineDataFields = Arrays.asList(
            Fields.date,
            Fields.open,
            Fields.high,
            Fields.low,
            Fields.close,
            Fields.yclose,
            Fields.vol,
            Fields.amount,
            Fields.capital,
            Fields.flowmarketvalue,
            Fields.exchangerate
    );


    /**
     * 股票交易分笔数据
     */
    public static Object stockTransactionsFields = Arrays.asList(
            Fields.name,
            Fields.symbol,
            Fields.yclose,
            Fields.company_releasedate,
            Fields.price,
            Fields.deal,
            Fields.date,
            Fields.limitprice
    );

    public static List<String> hotConceptFields = Arrays.asList(
            Fields.symbol,
            Fields.name,
            Fields.increase,
            Fields.indextop
    );

    public static List<String> RTKLineFields = Arrays.asList(
            Fields.date,
            Fields.minute
    );

    public static List<String> blockStockFields = Arrays.asList(
            Fields.symbol,
            Fields.name,
            Fields.price,
            Fields.risefall,
            Fields.increase,
            Fields.vol,
            Fields.yclose,
            Fields.company_releasedate,
            Fields.deListing
    );

    public static List<String> zlqhBlockStockFields = Arrays.asList(
            Fields.symbol,
            Fields.name,
            Fields.price,
            Fields.risefall,
            Fields.increase,
            Fields.vol,
            Fields.amount,
            Fields.open,
            Fields.yclose,
            Fields.high,
            Fields.low,
            Fields.exchangerate,
            Fields.pe,
            Fields.pe2,
            Fields.pe3,
            Fields.pb,
            Fields.amplitude,
            Fields.marketvalue,
            Fields.totalequity,
            Fields.bookrate
    );

    public static List<String> financeFields = Arrays.asList(
            Fields.symbol,
            Fields.finance
    );


    public static List<String> blockFields = Arrays.asList(
            Fields.symbol,
            Fields.name,
            Fields.increase,
            Fields.indextop,
            Fields.yclose
    );


    public static List<String> blockMemberFields = Arrays.asList(
            Fields.symbol,
            Fields.price,
            Fields.name,
            Fields.vol,
            Fields.open,
            Fields.yclose,
            Fields.increase,
            Fields.risefall,
            Fields.amplitude,
            Fields.high,
            Fields.low,
            Fields.pe,
            Fields.pe2,
            Fields.pe3,
            Fields.pb,
            Fields.bookrate,
            Fields.bookdiffer,
            Fields.amount,
            Fields.company_releasedate,
            Fields.exchangerate,
            Fields.totalequity,
            Fields.folwequity,
            Fields.deListing
    );


    public static List<String> stockV2Fields = Arrays.asList(
            Fields.symbol,
            Fields.price,
            Fields.name,
            Fields.vol,
            Fields.open,
            Fields.yclose,
            Fields.increase,
            Fields.risefall,
            Fields.amplitude,
            Fields.high,
            Fields.low,
            Fields.pe,
            Fields.pe2,
            Fields.pe3,
            Fields.pb,
            Fields.bookrate,
            Fields.amount,
            Fields.exchangerate,
            Fields.totalequity,
            Fields.folwequity
    );

    public static List<String> stockQuotesFields = Arrays.asList(
            Fields.symbol,
            Fields.price,
            Fields.name,
            Fields.vol,
            Fields.increase,
            Fields.yclose,
            Fields.buy,
            Fields.sell,
            Fields.date,
            Fields.stop,
            Fields.type,
            Fields.limitprice
    );

    public static List<String> zlqhStockCompanyFields = Arrays.asList(
            Fields.symbol,
            Fields.name,

            Fields.companyname,
            Fields.registeredaddress,
            Fields.homepage,

            Fields.chairman,
            Fields.legalrepresentative,

            Fields.registeredcapital,
            Fields.businesslicense,

            Fields.mainbusiness,
            Fields.businessscope
    );


    public static List<String> zlqhStockStaticFields = Arrays.asList(
            Fields.symbol,
            Fields.uplimit,
            Fields.dnlimit
    );



    public static List<String> zlqhStockQuotaFields = Arrays.asList(
            Fields.symbol,
            Fields.name,
            Fields.avprice,

            Fields.amplitude,
            Fields.bookrate,
            Fields.volratio,
            Fields.bookdiffer,
            Fields.exchangerate,

            Fields.increaseweek1,
            Fields.increaseweek4,
            Fields.increaseweek13,
            Fields.increaseweek26,
            Fields.increaseweek52,
            Fields.increasethisyear,

            Fields.eps,
            Fields.eps2,
            Fields.eps3,
            Fields.pe,
            Fields.pe2,
            Fields.pe3,
            Fields.pb,
            Fields.bv,
            Fields.roe,
            Fields.salesrevenue,
            Fields.netprofit,

            Fields.volin,
            Fields.volout,
            Fields.flowin,
            Fields.flowout,

            Fields.superin,
            Fields.superout,
            Fields.bigin,
            Fields.bigout,
            Fields.midin,
            Fields.midout,
            Fields.smallin,
            Fields.smallout,

            Fields.totalequity,
            Fields.folwequity,
            Fields.marketvalue,
            Fields.flowmarketvalue
    );
}
