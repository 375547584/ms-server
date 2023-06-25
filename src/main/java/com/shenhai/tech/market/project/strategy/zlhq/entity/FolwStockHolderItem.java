package com.shenhai.tech.market.project.strategy.zlhq.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 公告日期,
 股东名称,
 持股数量,
 占总股本比,
 占流通股本比,
 本期增减股数,
 股东类型,
 股份性质
 */

@Data
public class FolwStockHolderItem {
    //公告日期 - 20220930
    private String annDate;
    //股东名称 - 中国平安保险(集团)股份有限公司－集团本级－自有资金
    private String holdName;
    //持股数量 - 9618540236
    private Long holdQuantity;
    //占总股本比 - 49.56
    private BigDecimal holdRatio;
    //占流通股本比 - 0.00
    private BigDecimal holdFolwRatio;
    //本期增减股数 0
    private Long reduceHoldQuantity;
    //股东类型 - 保险公司
    private String holdProperty;
    //股份性质 - 流通A股
    private String stockProperty;
}
