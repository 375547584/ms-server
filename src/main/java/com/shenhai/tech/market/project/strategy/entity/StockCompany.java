package com.shenhai.tech.market.project.strategy.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockCompany {
    // 证券代码
    public String symbol;
    // 股票Code
    public String code;
    // 股票名称
    public String name;
    //公司全称
    public String companyname;
    // 上市日期
    public String firstday;
    //注册地址
    public String registeredaddress;
    //公司主页
    public String homepage;
    //董事长
    public String chairman;
    //法人代表
    public String legalrepresentative;
    // 注册资金
    public BigDecimal registeredcapital = BigDecimal.ZERO;
    // 营业执照
    public String businesslicense;
    // 主营业务
    public String mainbusiness;
    // 经营范围
    public String businessscope;
}
