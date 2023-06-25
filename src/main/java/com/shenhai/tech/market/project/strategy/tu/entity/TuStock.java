package com.shenhai.tech.market.project.strategy.tu.entity;

import com.shenhai.tech.market.common.utils.BigDecimalUtil;
import com.shenhai.tech.market.common.utils.LocalDateUtils;
import com.shenhai.tech.market.common.utils.StockUtils;
import com.shenhai.tech.market.project.strategy.entity.DelistStock;
import com.shenhai.tech.market.project.strategy.entity.Dividend;
import com.shenhai.tech.market.project.strategy.entity.Suspension;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TuStock {
    //600663.SH
    private String ts_code;
    // 20221206
    private String suspend_date;
    /**
     * 公告日
     */
    private String ann_date;
    /**
     * 实施进度
     */
    private String div_proc;
    /**
     * 每股送股比例
     */
    private BigDecimal stk_bo_rate;
    /**
     * 每股转增比例
     */
    private BigDecimal stk_co_rate;
    /**
     * 每股分红（税前）
     */
    private BigDecimal cash_div_tax;
    /**
     * 股权登记日
     */
    private String record_date;
    /**
     * 除权除息日
     */
    private String ex_date;
    /**
     * 派息日
     */
    private String pay_date;
    /**
     * 派息日
     */
    private String delist_date;


    private String holder_name;
    private String holder_type;
    private String in_de;
    private Long change_vol = 0L;
    private BigDecimal change_ratio = BigDecimal.ZERO;
    private Long after_share = 0L;
    private BigDecimal after_ratio = BigDecimal.ZERO;
    private BigDecimal total_share = BigDecimal.ZERO;
    private String begin_date;


    //注册资本
    private BigDecimal reg_capital = BigDecimal.ZERO;
    //法人代表
    private String chairman;
    //	注册日期
    private String setup_date;
    //所在省份
    private String province;
    //所在城市
    private String city;
    //公司介绍
    private String introduction;
    //经营范围
    private String business_scope;
    //员工人数
    private Long employees;
    //主要业务及产品
    private String main_business;

    //	姓名
    private String name;
    //岗位类别
    private String lev;
    //岗位
    private String title;
    //学历
    private String edu;
    //国籍
    private String national;
    //出生年份
    private String birthday;
    private String end_date;

    //上网发行日期
    private String ipo_date;
    //发行总量（万股）
    private BigDecimal amount;
    //上网发行总量（万股）
    private BigDecimal market_amount;
    //发行价格
    private BigDecimal price;
    //市盈率
    private BigDecimal pe;
    //个人申购上限（万股）
    private BigDecimal limit_amount;
    //募集资金（亿元）
    private BigDecimal funds;
    //	中签率
    private BigDecimal ballot;


    private String bz_item;
    private String bz_code;
    private BigDecimal bz_sales;
    private BigDecimal bz_profit;
    private BigDecimal bz_cost;
    private String curr_type;


    private BigDecimal float_share;
    private BigDecimal total_assets;
    private BigDecimal liquid_assets;
    private BigDecimal fixed_assets;
    private BigDecimal reserved;
    private BigDecimal reserved_pershare;
    private BigDecimal undp;
    private BigDecimal per_undp;
    private BigDecimal rev_yoy;
    private BigDecimal profit_yoy;
    private BigDecimal gpr;
    private BigDecimal npr;
    private Integer holder_num;


    // 货币资金
    private BigDecimal money_cap;
    // 应收账款
    private BigDecimal accounts_receiv;
    // 存货
    private BigDecimal inventories;
    // 流动资产合计
    private BigDecimal total_cur_assets;
    // 长期股权投资
    private BigDecimal lt_eqt_invest;
    // 固定资产
    private BigDecimal fix_assets;
    // 无形资产
    private BigDecimal intan_assets;
    // 应付账款
    private BigDecimal acct_payable;
    // 预收款项
    private BigDecimal adv_receipts;
    // 流动负债合计
    private BigDecimal total_cur_liab;
    // 非流动资产合计
    private BigDecimal total_nca;
    // 负债合计
    private BigDecimal total_liab;
    //资本公积金
    private BigDecimal cap_rese;
    //盈余公积金
    private BigDecimal surplus_rese;
    //股东权益合计(含少数股东权益)
    private BigDecimal total_hldr_eqy_inc_min_int;


    //销售商品、提供劳务收到的现金
    private BigDecimal c_fr_sale_sg;
    // 收到的税费返还
    private BigDecimal recp_tax_rends;
    //收到其他与经营活动有关的现金
    private BigDecimal c_fr_oth_operate_a;
    // 经营活动现金流入小计
    private BigDecimal c_inf_fr_operate_a;
    // 购买商品、接受劳务支付的现金
    private BigDecimal c_paid_goods_s;
    // 支付给职工以及为职工支付的现金
    private BigDecimal c_paid_to_for_empl;
    // 支付的各项税费
    private BigDecimal c_paid_for_taxes;
    // 支付其他与经营活动有关的现金
    private BigDecimal oth_cash_pay_oper_act;
    // 经营活动现金流出小计
    private BigDecimal st_cash_out_act;
    // 经营活动产生的现金流量净额
    private BigDecimal n_cashflow_act;
    // 取得投资收益收到的现金
    private BigDecimal c_recp_return_invest;
    // 投资活动现金流入小计
    private BigDecimal stot_inflows_inv_act;
    //购建固定资产、无形资产和其他长期资产支付的现金
    private BigDecimal c_pay_acq_const_fiolta;
    //处置固定资产、无形资产和其他长期资产收回的现金净额
    private BigDecimal n_recp_disp_fiolta;
    //投资支付的现金
    private BigDecimal c_paid_invest;
    //投资活动现金流出小计
    private BigDecimal stot_out_inv_act;
    //投资活动产生的现金流量净额
    private BigDecimal n_cashflow_inv_act;
    // 吸收投资收到的现金
    private BigDecimal c_recp_cap_contrib;
    // 取得借款收到的现金
    private BigDecimal c_recp_borrow;
    // 筹资活动现金流入小计
    private BigDecimal stot_cash_in_fnc_act;
    // 偿还债务支付的现金
    private BigDecimal c_prepay_amt_borr;
    // 分配股利、利润或偿付利息支付的现金
    private BigDecimal c_pay_dist_dpcp_int_exp;
    // 筹资活动现金流出小计
    private BigDecimal stot_cashout_fnc_act;
    // 筹资活动产生的现金流量净额
    private BigDecimal n_cash_flows_fnc_act;


    // 营业收入
    private BigDecimal revenue;
    // 营业支出
    private BigDecimal oper_exp;
    //营业总收入
    private BigDecimal total_revenue;
    // 营业总成本
    private BigDecimal total_cogs;
    // 销售费用
    private BigDecimal sell_exp;
    //财务费用
    private BigDecimal fin_exp;
    //管理费用
    private BigDecimal admin_exp;
    //资产减值损失
    private BigDecimal assets_impair_loss;
    //投资净收益
    private BigDecimal invest_income;
    //营业利润
    private BigDecimal operate_profit;
    //所得税费用
    private BigDecimal income_tax;
    //归属于母公司(或股东)的综合收益总额
    private BigDecimal compr_inc_attr_p;
    //净利润(含少数股东损益)
    private BigDecimal n_income;
    //净利润(不含少数股东损益)
    private BigDecimal n_income_attr_p;
    //归属于少数股东的综合收益总额
    private BigDecimal compr_inc_attr_m_s;
    //可供股东分配的利润
    private BigDecimal distr_profit_shrhder;
    //营业总成本（二）
    private BigDecimal total_opcost;


    //基本每股收益
    private BigDecimal eps;
    //稀释每股收益
    private BigDecimal dt_eps;
    //每股净资产
    private BigDecimal bps;
    //每股资本公积
    private BigDecimal capital_rese_ps;
    //每股未分配利润
    private BigDecimal undist_profit_ps;
    //每股经营活动产生的现金流量净额--每股经营现金流
    private BigDecimal ocfps;
    //扣非净利润
    private BigDecimal profit_dedt;
    //营业收入同比增长(%)
    private BigDecimal or_yoy;
    //营业收入同比增长率(%)(单季度)
    private BigDecimal q_sales_yoy;
    //归属净利润同比增长(%)
    private BigDecimal netprofit_yoy;
    //归属净利润同比增长(%)(单季度)
    private BigDecimal q_netprofit_yoy;
    //扣非净利润同比增长(%)
    private BigDecimal dtprofit_to_profit;
    //扣非净利润同比增长(%)(单季度)
    private BigDecimal q_dtprofit_to_profit;
    //加权净资产收益率-加权平均净资产收益率
    private BigDecimal roe_waa;
    //摊薄净资产收益率-平均净资产收益率(增发条件)
    private BigDecimal roe_avg;
    //净资产收益率
    private BigDecimal roe;
    //摊薄总资产收益率-年化总资产报酬率
    private BigDecimal roa2_yearly;
    //总资产报酬率
    private BigDecimal roa;
    //销售毛利率
    private BigDecimal grossprofit_margin;
    //销售毛利率(单季度)
    private BigDecimal q_gsprofit_margin;
    //销售净利率
    private BigDecimal netprofit_margin;
    //销售净利率(单季度)
    private BigDecimal q_netprofit_margin;
    //销售现金流/营业收入--销售商品提供劳务收到的现金/营业收入
    private BigDecimal salescash_to_or;
    //销售现金流/营业收入(单季度)
    private BigDecimal q_salescash_to_or;
    //经营现金流/营业收入---经营活动产生的现金流量净额/营业收入
    private BigDecimal ocf_to_or;
    //经营现金流/营业收入(单季度)---经营活动产生的现金流量净额/营业收入
    private BigDecimal q_ocf_to_or;
    //总资产周转率(次)
    private BigDecimal assets_turn;
    //应收账款周转天数(天)
    private BigDecimal arturn_days;
    //存货周转天数(天)
    private BigDecimal invturn_days;
    //资产负债率
    private BigDecimal debt_to_assets;
    //流动负债/总负债
    private BigDecimal currentdebt_to_debt;
    //流动比率
    private BigDecimal current_ratio;
    //速动比率
    private BigDecimal quick_ratio;

    public static Suspension castSuspension(TuStock tuStock) {
        String code = StockUtils.symbolToCode(tuStock.getTs_code());
        LocalDate suspendDate = LocalDateUtils.string2LocalDate(tuStock.getSuspend_date(), LocalDateUtils.formatterDD3);
        Suspension suspension = new Suspension();
        suspension.setStockCode(code);
        suspension.setStartDate(suspendDate);
        return suspension;
    }

    public static DelistStock castStopStock(TuStock tuStock) {
        String code = StockUtils.symbolToCode(tuStock.getTs_code());
        LocalDate delistDate = LocalDateUtils.string2LocalDate(tuStock.getDelist_date(), LocalDateUtils.formatterDD3);
        DelistStock delistStock = new DelistStock();
        delistStock.setStockCode(code);
        delistStock.setDelistDate(delistDate);
        return delistStock;
    }

    public static Dividend castDividend(TuStock tuStock) {
        Dividend dividend = new Dividend();
        dividend.setSymbol(StockUtils.LowerCase(tuStock.getTs_code()));
        dividend.setCode(StockUtils.symbolToCode(tuStock.getTs_code()));
        dividend.setSend(BigDecimalUtil.multiply10(tuStock.getCash_div_tax()));
        dividend.setGiveAway(BigDecimalUtil.multiply10(tuStock.getStk_bo_rate()));
        dividend.setIncrease(BigDecimalUtil.multiply10(tuStock.getStk_co_rate()));
        dividend.setAnnDate(LocalDateUtils.string2LocalDate(tuStock.getAnn_date(), LocalDateUtils.formatterDD3));
        dividend.setDividendDate(LocalDateUtils.string2LocalDate(tuStock.getEx_date(), LocalDateUtils.formatterDD3));
        dividend.setPayableDate(LocalDateUtils.string2LocalDate(tuStock.getPay_date(), LocalDateUtils.formatterDD3));
        dividend.setRegisterDate(LocalDateUtils.string2LocalDate(tuStock.getRecord_date(), LocalDateUtils.formatterDD3));
        dividend.setPlan(dividend.createPlan());
        return dividend;
    }


}
