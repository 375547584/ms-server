package com.shenhai.tech.market.project.strategy.entity;

import com.shenhai.tech.market.common.utils.BigDecimalUtil;
import com.shenhai.tech.market.common.utils.LocalDateUtils;
import com.shenhai.tech.market.common.utils.StockUtils;
import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.service.entity.StockExRights;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Dividend {

    private String symbol;

    private String code;

    private String name;

    /**
     * 公告日期
     */
    private LocalDate annDate;

    /**
     * 分红方案 10派0.30(含税)
     */
    private String plan;

    /**
     * 股权登记日
     */
    private LocalDate registerDate;

    /**
     * 除权除息日
     */
    private LocalDate dividendDate;

    /**
     * 派息日
     */
    private LocalDate payableDate;


    /**
     * 10股 派-分红 2.40
     */
    private BigDecimal send;

    /**
     * 10股 送-送股 1
     */
    private BigDecimal giveAway;

    /**
     * 10股 增-转增 1
     */
    private BigDecimal increase;




    public String getUniqueId() {
        return String.format("%s_%s", code, LocalDateUtils.format(dividendDate, LocalDateUtils.formatterDD3));
    }

    public static List<Dividend> castDividends(List<StockExRights> stockExRights) {
        if(StringUtils.isEmpty(stockExRights)) {
            return null;
        }
        List<Dividend> dividends = new ArrayList<>();
        for (StockExRights stockExRight : stockExRights) {
            Dividend dividend = castDividend(stockExRight);
            if(dividend != null) {
                dividends.add(dividend);
            }
        }
        return dividends;
    }

    public static Dividend castDividend(StockExRights stockExRight) {
        if(stockExRight == null) {
            return null;
        }
        Dividend dividend = new Dividend();
        dividend.setSymbol(StockUtils.codeToSymbol(stockExRight.getStockCode()));
        dividend.setCode(stockExRight.getStockCode());
        dividend.setName(stockExRight.getStockName());
        dividend.setSend(stockExRight.getDividend());
        dividend.setGiveAway(stockExRight.getBonus());
        dividend.setIncrease(stockExRight.getRebate());
        dividend.setAnnDate(stockExRight.getAnnDate());
        dividend.setRegisterDate(stockExRight.getRegisterDate());
        dividend.setDividendDate(stockExRight.getDividendDate());
        dividend.setPayableDate(stockExRight.getPayableDate());
        dividend.setPlan(dividend.createPlan());
        return dividend;
    }



    public static List<StockExRights> cast(Stock stock, List<Dividend> dividends) {
        if(StringUtils.isEmpty(dividends)) {
            return null;
        }
        List<StockExRights> stockExRights = new ArrayList<>();
        for (Dividend dividend : dividends) {
            StockExRights stockExRight = cast(dividend);
            if(stockExRight != null) {
                stockExRight.setStockCode(stock.getCode());
                stockExRight.setStockName(stock.getName());
                stockExRight.setId(stockExRight.getUniqueId());
                stockExRights.add(stockExRight);
            }
        }
        return stockExRights;
    }

    public static StockExRights cast(Dividend dividend) {
        if(dividend == null) {
            return null;
        }
        StockExRights stockExRight = new StockExRights();
        stockExRight.setStockCode(dividend.getCode());
        stockExRight.setStockName(dividend.getName());
        stockExRight.setDividend(dividend.getSend());
        stockExRight.setBonus(dividend.getGiveAway());
        stockExRight.setRebate(dividend.getIncrease());
        stockExRight.setRemark(dividend.getPlan());
        stockExRight.setAnnDate(dividend.getAnnDate());
        stockExRight.setRegisterDate(dividend.getRegisterDate());
        stockExRight.setDividendDate(dividend.getDividendDate());
        stockExRight.setPayableDate(dividend.getPayableDate());
        return stockExRight;
    }

    public String createPlan() {
        if (BigDecimalUtil.leeqZero(send) && BigDecimalUtil.leeqZero(giveAway) && BigDecimalUtil.leeqZero(increase)) {
            return "";
        }
        String plan = "10股";
        if (BigDecimalUtil.gtZero(send)) {
            plan = String.format("%s派%s", plan, send);
        }
        if (BigDecimalUtil.gtZero(giveAway)) {
            plan = String.format("%s送%s", plan, giveAway);
        }
        if (BigDecimalUtil.gtZero(increase)) {
            plan = String.format("%s增%s", plan, increase);
        }
        return plan;
    }
}
