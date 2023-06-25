package com.shenhai.tech.market.project.strategy.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.math.BigDecimal;

public class Stock {
    private String symbol;//股票代码
    private String code;//股票代码
    private String name;//股票名称

    private String stockJaneSpell; //股票简拼

    private String block;//所属板块(SH,SZ)

    private String state;//股票状态
    private String date;//交易日期
    private String time;//交易时间 10:50:30
    @TableField(exist = false)
    private Integer decimal;//小数位数 2


    private BigDecimal openPrice;//开盘价
    private BigDecimal yClose;//昨日收盘价
    private BigDecimal price;//最新价
    private BigDecimal highPrice;//最高股价
    private BigDecimal lowPrice;//最低股价
    private BigDecimal avprice;//均价股价

    private BigDecimal increase;//涨跌幅
    private BigDecimal risefall;//涨跌
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
    private String firstday;//上市日期

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



    private Integer stop = 0;//停牌股票数量
    private Integer up = 0;//涨停股票数量
    private Integer down = 0;//跌停股票数量
    private Integer unchanged = 0;//平盘的股票数量

    private BigDecimal fallStopPrice;//跌停价
    private BigDecimal riseStopPrice;//涨停价

    private Long totaleQuity;//总股本
    private Long folweQuity;//流通股本
    private BigDecimal totaleValue; //总市值
    private BigDecimal folweValue; //流通市值

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


    @TableField(exist = false)
    private BigDecimal buypx1 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx2 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx3 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx4 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx5 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx6 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx7 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx8 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx9 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal buypx10 = BigDecimal.ZERO;

    @TableField(exist = false)
    private Long buyvol1 = 0L;
    @TableField(exist = false)
    private Long buyvol2 = 0L;
    @TableField(exist = false)
    private Long buyvol3 = 0L;
    @TableField(exist = false)
    private Long buyvol4 = 0L;
    @TableField(exist = false)
    private Long buyvol5 = 0L;
    @TableField(exist = false)
    private Long buyvol6 = 0L;
    @TableField(exist = false)
    private Long buyvol7 = 0L;
    @TableField(exist = false)
    private Long buyvol8 = 0L;
    @TableField(exist = false)
    private Long buyvol9 = 0L;
    @TableField(exist = false)
    private Long buyvol10 = 0L;

    @TableField(exist = false)
    private BigDecimal sellpx1 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx2 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx3 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx4 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx5 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx6 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx7 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx8 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx9 = BigDecimal.ZERO;
    @TableField(exist = false)
    private BigDecimal sellpx10 = BigDecimal.ZERO;

    @TableField(exist = false)
    private Long sellvol1 = 0L;
    @TableField(exist = false)
    private Long sellvol2 = 0L;
    @TableField(exist = false)
    private Long sellvol3 = 0L;
    @TableField(exist = false)
    private Long sellvol4 = 0L;
    @TableField(exist = false)
    private Long sellvol5 = 0L;
    @TableField(exist = false)
    private Long sellvol6 = 0L;
    @TableField(exist = false)
    private Long sellvol7 = 0L;
    @TableField(exist = false)
    private Long sellvol8 = 0L;
    @TableField(exist = false)
    private Long sellvol9 = 0L;
    @TableField(exist = false)
    private Long sellvol10 = 0L;

    @TableField("isindex")
    private Integer isindex;//是否指数
    @TableField("is_delisting")
    private Boolean isDelisting = false;//是否退市
    @TableField("is_suspension")
    private Boolean isSuspension = false;//是否停牌
    @TableField("is_new")
    private Boolean isNew = false;//是否新股
    @TableField("is_sub_new")
    private Boolean isSubNew = false;//是否次新股
    @TableField("is_sh")
    private Boolean isSH = false;//是否沪市
    @TableField("is_sz")
    private Boolean isSZ = false;//是否深市
    @TableField("is_kc")
    private Boolean isKC = false;//是否科创板
    @TableField("is_cy")
    private Boolean isCY = false;//是否创业板
    @TableField("is_zx")
    private Boolean isZX = false;//是否中小板

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getDecimal() {
        if(decimal == null) {
            return 2;
        }
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        if(decimal == null) {
            this.decimal = 2;
        }
        else {
            this.decimal = decimal;
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStockJaneSpell() {
        return stockJaneSpell;
    }

    public void setStockJaneSpell(String stockJaneSpell) {
        this.stockJaneSpell = stockJaneSpell;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getState() {
        if(getIsDelisting() != null && getIsDelisting()) {
            return "已退市";
        }
        else if(getIsSuspension() != null && getIsSuspension()) {
            return "已停牌";
        }
        else {
            return state;
        }
    }

    public void setState(String state) {
        if(isDelisting != null && isDelisting) {
            this.state = "已退市";
        }
        else if(isSuspension != null && isSuspension) {
            this.state = "已停牌";
        }
        else {
            this.state = state;
        }
    }


    public BigDecimal getPrice() {
        if(getIsDelisting() != null && getIsDelisting()) {
            return yClose;
        }
        else if(getIsSuspension() != null && getIsSuspension()) {
            return yClose;
        }
        else {
            return price;
        }
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getIncrease() {
        if(getIsDelisting() != null && getIsDelisting()) {
            return BigDecimal.ZERO;
        }
        else if(getIsSuspension() != null && getIsSuspension()) {
            return BigDecimal.ZERO;
        }
        else {
            return increase;
        }
    }

    public void setIncrease(BigDecimal increase) {
        if(getIsDelisting() != null && getIsDelisting()) {
            this.increase = BigDecimal.ZERO;
        }
        else if(getIsSuspension() != null && getIsSuspension()) {
            this.increase = BigDecimal.ZERO;
        }
        else {
            this.increase = increase;
        }
    }

    public BigDecimal getRisefall() {
        if(getIsDelisting() != null && getIsDelisting()) {
            return BigDecimal.ZERO;
        }
        else if(getIsSuspension() != null && getIsSuspension()) {
            return BigDecimal.ZERO;
        }
        else {
            return risefall;
        }
    }

    public void setRisefall(BigDecimal risefall) {
        if(getIsDelisting() != null && getIsDelisting()) {
            this.risefall = BigDecimal.ZERO;
        }
        else if(getIsSuspension() != null && getIsSuspension()) {
            this.risefall = BigDecimal.ZERO;
        }
        else {
            this.risefall = risefall;
        }
    }



    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getyClose() {
        return yClose;
    }

    public void setyClose(BigDecimal yClose) {
        this.yClose = yClose;
    }


    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getAvprice() {
        return avprice;
    }

    public void setAvprice(BigDecimal avprice) {
        this.avprice = avprice;
    }


    public BigDecimal getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(BigDecimal amplitude) {
        this.amplitude = amplitude;
    }

    public BigDecimal getVolratio() {
        return volratio;
    }

    public void setVolratio(BigDecimal volratio) {
        this.volratio = volratio;
    }

    public BigDecimal getBookrate() {
        return bookrate;
    }

    public void setBookrate(BigDecimal bookrate) {
        this.bookrate = bookrate;
    }

    public BigDecimal getBookdiffer() {
        return bookdiffer;
    }

    public void setBookdiffer(BigDecimal bookdiffer) {
        this.bookdiffer = bookdiffer;
    }

    public BigDecimal getIncreaseweek1() {
        return increaseweek1;
    }

    public void setIncreaseweek1(BigDecimal increaseweek1) {
        this.increaseweek1 = increaseweek1;
    }

    public BigDecimal getIncreaseweek4() {
        return increaseweek4;
    }

    public void setIncreaseweek4(BigDecimal increaseweek4) {
        this.increaseweek4 = increaseweek4;
    }

    public BigDecimal getIncreaseweek13() {
        return increaseweek13;
    }

    public void setIncreaseweek13(BigDecimal increaseweek13) {
        this.increaseweek13 = increaseweek13;
    }

    public BigDecimal getIncreaseweek26() {
        return increaseweek26;
    }

    public void setIncreaseweek26(BigDecimal increaseweek26) {
        this.increaseweek26 = increaseweek26;
    }

    public BigDecimal getIncreaseweek52() {
        return increaseweek52;
    }

    public void setIncreaseweek52(BigDecimal increaseweek52) {
        this.increaseweek52 = increaseweek52;
    }

    public BigDecimal getIncreasethisyear() {
        return increasethisyear;
    }

    public void setIncreasethisyear(BigDecimal increasethisyear) {
        this.increasethisyear = increasethisyear;
    }

    public String getFirstday() {
        return firstday;
    }

    public void setFirstday(String firstday) {
        this.firstday = firstday;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getPe() {
        return pe;
    }

    public void setPe(BigDecimal pe) {
        this.pe = pe;
    }

    public BigDecimal getPe2() {
        return pe2;
    }

    public void setPe2(BigDecimal pe2) {
        this.pe2 = pe2;
    }

    public BigDecimal getPe3() {
        return pe3;
    }

    public void setPe3(BigDecimal pe3) {
        this.pe3 = pe3;
    }

    public BigDecimal getEps() {
        return eps;
    }

    public void setEps(BigDecimal eps) {
        this.eps = eps;
    }

    public BigDecimal getEps2() {
        return eps2;
    }

    public void setEps2(BigDecimal eps2) {
        this.eps2 = eps2;
    }

    public BigDecimal getEps3() {
        return eps3;
    }

    public void setEps3(BigDecimal eps3) {
        this.eps3 = eps3;
    }

    public BigDecimal getPb() {
        return pb;
    }

    public void setPb(BigDecimal pb) {
        this.pb = pb;
    }

    public BigDecimal getBv() {
        return bv;
    }

    public void setBv(BigDecimal bv) {
        this.bv = bv;
    }

    public BigDecimal getRoe() {
        return roe;
    }

    public void setRoe(BigDecimal roe) {
        this.roe = roe;
    }

    public BigDecimal getSalesrevenue() {
        return salesrevenue;
    }

    public void setSalesrevenue(BigDecimal salesrevenue) {
        this.salesrevenue = salesrevenue;
    }

    public BigDecimal getNetprofit() {
        return netprofit;
    }

    public void setNetprofit(BigDecimal netprofit) {
        this.netprofit = netprofit;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public Integer getUnchanged() {
        return unchanged;
    }

    public void setUnchanged(Integer unchanged) {
        this.unchanged = unchanged;
    }

    public BigDecimal getFallStopPrice() {
        return fallStopPrice;
    }

    public void setFallStopPrice(BigDecimal fallStopPrice) {
        this.fallStopPrice = fallStopPrice;
    }

    public BigDecimal getRiseStopPrice() {
        return riseStopPrice;
    }

    public void setRiseStopPrice(BigDecimal riseStopPrice) {
        this.riseStopPrice = riseStopPrice;
    }

    public Long getTotaleQuity() {
        return totaleQuity;
    }

    public void setTotaleQuity(Long totaleQuity) {
        this.totaleQuity = totaleQuity;
    }

    public Long getFolweQuity() {
        return folweQuity;
    }

    public void setFolweQuity(Long folweQuity) {
        this.folweQuity = folweQuity;
    }

    public BigDecimal getTotaleValue() {
        return totaleValue;
    }

    public void setTotaleValue(BigDecimal totaleValue) {
        this.totaleValue = totaleValue;
    }

    public BigDecimal getFolweValue() {
        return folweValue;
    }

    public void setFolweValue(BigDecimal folweValue) {
        this.folweValue = folweValue;
    }

    public Long getVol() {
        return vol;
    }

    public void setVol(Long vol) {
        this.vol = vol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getVolin() {
        return volin;
    }

    public void setVolin(Long volin) {
        this.volin = volin;
    }

    public Long getVolout() {
        return volout;
    }

    public void setVolout(Long volout) {
        this.volout = volout;
    }

    public BigDecimal getFlowin() {
        return flowin;
    }

    public void setFlowin(BigDecimal flowin) {
        this.flowin = flowin;
    }

    public BigDecimal getFlowout() {
        return flowout;
    }

    public void setFlowout(BigDecimal flowout) {
        this.flowout = flowout;
    }

    public BigDecimal getSuperin() {
        return superin;
    }

    public void setSuperin(BigDecimal superin) {
        this.superin = superin;
    }

    public BigDecimal getSuperout() {
        return superout;
    }

    public void setSuperout(BigDecimal superout) {
        this.superout = superout;
    }

    public BigDecimal getBigin() {
        return bigin;
    }

    public void setBigin(BigDecimal bigin) {
        this.bigin = bigin;
    }

    public BigDecimal getBigout() {
        return bigout;
    }

    public void setBigout(BigDecimal bigout) {
        this.bigout = bigout;
    }

    public BigDecimal getMidin() {
        return midin;
    }

    public void setMidin(BigDecimal midin) {
        this.midin = midin;
    }

    public BigDecimal getMidout() {
        return midout;
    }

    public void setMidout(BigDecimal midout) {
        this.midout = midout;
    }

    public BigDecimal getSmallin() {
        return smallin;
    }

    public void setSmallin(BigDecimal smallin) {
        this.smallin = smallin;
    }

    public BigDecimal getSmallout() {
        return smallout;
    }

    public void setSmallout(BigDecimal smallout) {
        this.smallout = smallout;
    }

    public BigDecimal getBuypx1() {
        return buypx1;
    }

    public void setBuypx1(BigDecimal buypx1) {
        this.buypx1 = buypx1;
    }

    public BigDecimal getBuypx2() {
        return buypx2;
    }

    public void setBuypx2(BigDecimal buypx2) {
        this.buypx2 = buypx2;
    }

    public BigDecimal getBuypx3() {
        return buypx3;
    }

    public void setBuypx3(BigDecimal buypx3) {
        this.buypx3 = buypx3;
    }

    public BigDecimal getBuypx4() {
        return buypx4;
    }

    public void setBuypx4(BigDecimal buypx4) {
        this.buypx4 = buypx4;
    }

    public BigDecimal getBuypx5() {
        return buypx5;
    }

    public void setBuypx5(BigDecimal buypx5) {
        this.buypx5 = buypx5;
    }

    public BigDecimal getBuypx6() {
        return buypx6;
    }

    public void setBuypx6(BigDecimal buypx6) {
        this.buypx6 = buypx6;
    }

    public BigDecimal getBuypx7() {
        return buypx7;
    }

    public void setBuypx7(BigDecimal buypx7) {
        this.buypx7 = buypx7;
    }

    public BigDecimal getBuypx8() {
        return buypx8;
    }

    public void setBuypx8(BigDecimal buypx8) {
        this.buypx8 = buypx8;
    }

    public BigDecimal getBuypx9() {
        return buypx9;
    }

    public void setBuypx9(BigDecimal buypx9) {
        this.buypx9 = buypx9;
    }

    public BigDecimal getBuypx10() {
        return buypx10;
    }

    public void setBuypx10(BigDecimal buypx10) {
        this.buypx10 = buypx10;
    }

    public Long getBuyvol1() {
        return buyvol1;
    }

    public void setBuyvol1(Long buyvol1) {
        this.buyvol1 = buyvol1;
    }

    public Long getBuyvol2() {
        return buyvol2;
    }

    public void setBuyvol2(Long buyvol2) {
        this.buyvol2 = buyvol2;
    }

    public Long getBuyvol3() {
        return buyvol3;
    }

    public void setBuyvol3(Long buyvol3) {
        this.buyvol3 = buyvol3;
    }

    public Long getBuyvol4() {
        return buyvol4;
    }

    public void setBuyvol4(Long buyvol4) {
        this.buyvol4 = buyvol4;
    }

    public Long getBuyvol5() {
        return buyvol5;
    }

    public void setBuyvol5(Long buyvol5) {
        this.buyvol5 = buyvol5;
    }

    public Long getBuyvol6() {
        return buyvol6;
    }

    public void setBuyvol6(Long buyvol6) {
        this.buyvol6 = buyvol6;
    }

    public Long getBuyvol7() {
        return buyvol7;
    }

    public void setBuyvol7(Long buyvol7) {
        this.buyvol7 = buyvol7;
    }

    public Long getBuyvol8() {
        return buyvol8;
    }

    public void setBuyvol8(Long buyvol8) {
        this.buyvol8 = buyvol8;
    }

    public Long getBuyvol9() {
        return buyvol9;
    }

    public void setBuyvol9(Long buyvol9) {
        this.buyvol9 = buyvol9;
    }

    public Long getBuyvol10() {
        return buyvol10;
    }

    public void setBuyvol10(Long buyvol10) {
        this.buyvol10 = buyvol10;
    }

    public BigDecimal getSellpx1() {
        return sellpx1;
    }

    public void setSellpx1(BigDecimal sellpx1) {
        this.sellpx1 = sellpx1;
    }

    public BigDecimal getSellpx2() {
        return sellpx2;
    }

    public void setSellpx2(BigDecimal sellpx2) {
        this.sellpx2 = sellpx2;
    }

    public BigDecimal getSellpx3() {
        return sellpx3;
    }

    public void setSellpx3(BigDecimal sellpx3) {
        this.sellpx3 = sellpx3;
    }

    public BigDecimal getSellpx4() {
        return sellpx4;
    }

    public void setSellpx4(BigDecimal sellpx4) {
        this.sellpx4 = sellpx4;
    }

    public BigDecimal getSellpx5() {
        return sellpx5;
    }

    public void setSellpx5(BigDecimal sellpx5) {
        this.sellpx5 = sellpx5;
    }

    public BigDecimal getSellpx6() {
        return sellpx6;
    }

    public void setSellpx6(BigDecimal sellpx6) {
        this.sellpx6 = sellpx6;
    }

    public BigDecimal getSellpx7() {
        return sellpx7;
    }

    public void setSellpx7(BigDecimal sellpx7) {
        this.sellpx7 = sellpx7;
    }

    public BigDecimal getSellpx8() {
        return sellpx8;
    }

    public void setSellpx8(BigDecimal sellpx8) {
        this.sellpx8 = sellpx8;
    }

    public BigDecimal getSellpx9() {
        return sellpx9;
    }

    public void setSellpx9(BigDecimal sellpx9) {
        this.sellpx9 = sellpx9;
    }

    public BigDecimal getSellpx10() {
        return sellpx10;
    }

    public void setSellpx10(BigDecimal sellpx10) {
        this.sellpx10 = sellpx10;
    }

    public Long getSellvol1() {
        return sellvol1;
    }

    public void setSellvol1(Long sellvol1) {
        this.sellvol1 = sellvol1;
    }

    public Long getSellvol2() {
        return sellvol2;
    }

    public void setSellvol2(Long sellvol2) {
        this.sellvol2 = sellvol2;
    }

    public Long getSellvol3() {
        return sellvol3;
    }

    public void setSellvol3(Long sellvol3) {
        this.sellvol3 = sellvol3;
    }

    public Long getSellvol4() {
        return sellvol4;
    }

    public void setSellvol4(Long sellvol4) {
        this.sellvol4 = sellvol4;
    }

    public Long getSellvol5() {
        return sellvol5;
    }

    public void setSellvol5(Long sellvol5) {
        this.sellvol5 = sellvol5;
    }

    public Long getSellvol6() {
        return sellvol6;
    }

    public void setSellvol6(Long sellvol6) {
        this.sellvol6 = sellvol6;
    }

    public Long getSellvol7() {
        return sellvol7;
    }

    public void setSellvol7(Long sellvol7) {
        this.sellvol7 = sellvol7;
    }

    public Long getSellvol8() {
        return sellvol8;
    }

    public void setSellvol8(Long sellvol8) {
        this.sellvol8 = sellvol8;
    }

    public Long getSellvol9() {
        return sellvol9;
    }

    public void setSellvol9(Long sellvol9) {
        this.sellvol9 = sellvol9;
    }

    public Long getSellvol10() {
        return sellvol10;
    }

    public void setSellvol10(Long sellvol10) {
        this.sellvol10 = sellvol10;
    }

    public Integer getIsindex() {
        return isindex;
    }

    public void setIsindex(Integer isindex) {
        this.isindex = isindex;
    }

    public Boolean getIsDelisting() {
        return isDelisting;
    }

    public void setIsDelisting(Boolean delisting) {
        isDelisting = delisting;
    }

    public Boolean getIsSuspension() {
        return isSuspension;
    }

    public void setIsSuspension(Boolean suspension) {
        isSuspension = suspension;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getIsSubNew() {
        return isSubNew;
    }

    public void setIsSubNew(Boolean subNew) {
        isSubNew = subNew;
    }

    public Boolean getIsSH() {
        return isSH;
    }

    public void setIsSH(Boolean sh) {
        isSH = sh;
    }

    public Boolean getIsSZ() {
        return isSZ;
    }

    public void setIsSZ(Boolean sz) {
        isSZ = sz;
    }

    public Boolean getIsKC() {
        return isKC;
    }

    public void setIsKC(Boolean kc) {
        isKC = kc;
    }

    public Boolean getIsCY() {
        return isCY;
    }

    public void setIsCY(Boolean cy) {
        isCY = cy;
    }

    public Boolean getIsZX() {
        return isZX;
    }

    public void setIsZX(Boolean zx) {
        isZX = zx;
    }
}