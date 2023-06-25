package com.shenhai.tech.market.project.strategy.zlhq.entity;

import com.shenhai.tech.market.common.utils.LocalDateUtils;
import com.shenhai.tech.market.common.utils.StockUtils;
import com.shenhai.tech.market.common.utils.TradingTimeUtils;
import com.shenhai.tech.market.project.strategy.entity.Dividend;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class HQDividend {
    /**
     * 股票代码
     */
    private String symbol;
    /**
     * 公告日期
     */
    private String dateofannouncement;
    /**
     * 除权除息日期
     */
    private String exdividenddate;
    /**
     * 10股税前红利
     */
    private BigDecimal pretaxdividend;
    /**
     * 10股税后红利
     */
    private BigDecimal aftertaxdividend;
    /**
     * b、h 股税前红利
     */
    private BigDecimal pretaxdividendbh;
    /**
     * b、h 股税后红利
     */
    private BigDecimal aftertaxdividendbh;
    /**
     * 10股送股比例
     */
    private BigDecimal sharegivingratio;
    /**
     * 10股转赠比例
     */
    private BigDecimal transferproportion;
    /**
     * 10股配股比例
     */
    private BigDecimal allotmentratio;
    /**
     * 配股价
     */
    private BigDecimal allotmentprice;

    public static Dividend castDividend(String holidays, HQDividend hqDividend) {
        Dividend dividend = new Dividend();
        dividend.setSymbol(StockUtils.LowerCase(hqDividend.getSymbol()));
        dividend.setCode(StockUtils.symbolToCode(hqDividend.getSymbol()));
        dividend.setSend(hqDividend.getPretaxdividend());
        dividend.setGiveAway(hqDividend.getSharegivingratio());
        dividend.setIncrease(hqDividend.getTransferproportion());
        dividend.setAnnDate(LocalDateUtils.string2LocalDate(hqDividend.getDateofannouncement(), LocalDateUtils.formatterDD3));
        LocalDate dividendDate = LocalDateUtils.string2LocalDate(hqDividend.getExdividenddate(), LocalDateUtils.formatterDD3);
        dividend.setDividendDate(dividendDate);
        LocalDate registerDate = TradingTimeUtils.getPreTradeDay(dividendDate, holidays);
        dividend.setRegisterDate(registerDate);
        dividend.setPlan(dividend.createPlan());
        return dividend;
    }
}
