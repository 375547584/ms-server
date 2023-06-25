package com.shenhai.tech.market.project.strategy.tu.entity;

import java.util.Arrays;
import java.util.List;

/**
 * 股票常量信息
 *
 * @author capital
 */
public class TuFields {

    public static String ts_code = "ts_code";
    public static String suspend_date = "suspend_date";
    public static String resume_date = "resume_date";
    public static String suspend_reason = "suspend_reason";

    /**
     * 公告日
     */
    public static String ann_date = "ann_date";
    /**
     * 实施进度
     */
    public static String div_proc = "div_proc";
    /**
     * 每股送股比例
     */
    public static String stk_bo_rate = "stk_bo_rate";
    /**
     * 每股转增比例
     */
    public static String stk_co_rate = "stk_co_rate";
    /**
     * 每股分红（税前）
     */
    public static String cash_div_tax = "cash_div_tax";
    /**
     * 股权登记日
     */
    public static String record_date = "record_date";
    /**
     * 除权除息日
     */
    public static String ex_date = "ex_date";
    /**
     * 派息日
     */
    public static String pay_date = "pay_date";
    public static String delist_date = "delist_date";

    public static String holder_name = "holder_name";
    public static String holder_type = "holder_type";
    public static String in_de = "in_de";
    public static String change_vol = "change_vol";
    public static String change_ratio = "change_ratio";
    public static String after_share = "after_share";
    public static String after_ratio = "after_ratio";
    public static String total_share = "total_share";
    public static String begin_date = "begin_date";


    //注册资本
    public static String reg_capital = "reg_capital";
    //法人代表
    public static String chairman = "chairman";
    //	注册日期
    public static String setup_date = "setup_date";
    //所在省份
    public static String province = "province";
    //所在城市
    public static String city = "city";
    //公司介绍
    public static String introduction = "introduction";
    //经营范围
    public static String business_scope = "business_scope";
    //员工人数
    public static String employees = "employees";
    //主要业务及产品
    public static String main_business = "main_business";


    //	姓名
    public static String name = "name";
    //岗位类别
    public static String lev = "lev";
    //岗位
    public static String title = "title";
    //学历
    public static String edu = "edu";
    //国籍
    public static String national = "national";
    //出生年份
    public static String birthday = "birthday";
    public static String end_date = "end_date";


    //上网发行日期
    public static String ipo_date = "ipo_date";
    //发行总量（万股）
    public static String amount = "amount";
    //上网发行总量（万股）
    public static String market_amount = "market_amount";
    //发行价格
    public static String price = "price";
    //市盈率
    public static String pe = "pe";
    //个人申购上限（万股）
    public static String limit_amount = "limit_amount";
    //募集资金（亿元）
    public static String funds = "funds";
    //	中签率
    public static String ballot = "ballot";

    //主营业务项目
    public static String bz_item = "bz_item";
    //项目代码
    public static String bz_code = "bz_code";
    // 主营业务收入(元)
    public static String bz_sales = "bz_sales";
    // 主营业务利润(元)
    public static String bz_profit = "bz_profit";
    // 主营业务成本(元)
    public static String bz_cost = "bz_cost";
    // 货币代码
    public static String curr_type = "curr_type";


    //流通股本（万）
    public static String float_share = "float_share";
    //总资产（万）
    public static String total_assets = "total_assets";
    //流动资产（万）
    public static String liquid_assets = "liquid_assets";
    //固定资产（万）
    public static String fixed_assets = "fixed_assets";
    //公积金
    public static String reserved = "reserved";
    //每股公积金
    public static String reserved_pershare = "reserved_pershare";
    //未分配利润
    public static String undp = "undp";
    //每股未分配利润
    public static String per_undp = "per_undp";
    //收入同比（%)
    public static String rev_yoy = "rev_yoy";
    //利润同比（%）
    public static String profit_yoy = "profit_yoy";
    //毛利率（%）
    public static String gpr = "gpr";
    //净利润率（%）
    public static String npr = "npr";
    // 股东人数
    public static String holder_num = "holder_num";


    /***************************资产损益表---利润表*****************************/
    // 营业收入
    public static String revenue = "revenue";
    // 营业支出
    public static String oper_exp = "oper_exp";
    //营业总收入
    public static String total_revenue = "total_revenue";
    // 营业总成本
    public static String total_cogs = "total_cogs";
    // 销售费用
    public static String sell_exp = "sell_exp";
    //财务费用
    public static String fin_exp = "fin_exp";
    //管理费用
    public static String admin_exp = "admin_exp";
    //资产减值损失
    public static String assets_impair_loss = "assets_impair_loss";
    //投资净收益
    public static String invest_income = "invest_income";
    //营业利润
    public static String operate_profit = "operate_profit";
    //所得税费用
    public static String income_tax = "income_tax";
    //净利润(含少数股东损益)
    public static String n_income = "n_income";
    //净利润(不含少数股东损益)
    public static String n_income_attr_p = "n_income_attr_p";
    //归属于母公司(或股东)的综合收益总额
    public static String compr_inc_attr_p = "compr_inc_attr_p";
    //归属于少数股东的综合收益总额
    public static String compr_inc_attr_m_s = "compr_inc_attr_m_s";
    //可供股东分配的利润
    public static String distr_profit_shrhder = "distr_profit_shrhder";
    //营业总成本（二）
    public static String total_opcost = "total_opcost";


    /***************************资产负债表---资产负债表*****************************/
    // 货币资金
    public static String money_cap = "money_cap";
    // 应收账款
    public static String accounts_receiv = "accounts_receiv";
    // 存货
    public static String inventories = "inventories";
    // 流动资产合计
    public static String total_cur_assets = "total_cur_assets";
    // 长期股权投资
    public static String lt_eqt_invest = "lt_eqt_invest";
    // 固定资产
    public static String fix_assets = "fix_assets";
    // 无形资产
    public static String intan_assets = "intan_assets";
    // 资产总计
    //public static String total_assets = "total_assets";
    // 应付账款
    public static String acct_payable = "acct_payable";
    // 预收款项
    public static String adv_receipts = "adv_receipts";
    // 流动负债合计
    public static String total_cur_liab = "total_cur_liab";
    // 非流动资产合计
    public static String total_nca = "total_nca";
    // 负债合计
    public static String total_liab = "total_liab";
    //资本公积金
    public static String cap_rese = "cap_rese";
    //盈余公积金
    public static String surplus_rese = "surplus_rese";
    //股东权益合计(含少数股东权益)
    public static String total_hldr_eqy_inc_min_int = "total_hldr_eqy_inc_min_int";


    /***************************现金流量表---现金流量表*****************************/
    //销售商品、提供劳务收到的现金
    public static String c_fr_sale_sg = "c_fr_sale_sg";
    // 收到的税费返还
    public static String recp_tax_rends = "recp_tax_rends";
    //收到其他与经营活动有关的现金
    public static String c_fr_oth_operate_a = "c_fr_oth_operate_a";
    // 经营活动现金流入小计
    public static String c_inf_fr_operate_a = "c_inf_fr_operate_a";
    // 购买商品、接受劳务支付的现金
    public static String c_paid_goods_s = "c_paid_goods_s";
    // 支付给职工以及为职工支付的现金
    public static String c_paid_to_for_empl = "c_paid_to_for_empl";
    // 支付的各项税费
    public static String c_paid_for_taxes = "c_paid_for_taxes";
    // 支付其他与经营活动有关的现金
    public static String oth_cash_pay_oper_act = "oth_cash_pay_oper_act";
    // 经营活动现金流出小计
    public static String st_cash_out_act = "st_cash_out_act";
    // 经营活动产生的现金流量净额
    public static String n_cashflow_act = "n_cashflow_act";
    // 取得投资收益收到的现金
    public static String c_recp_return_invest = "c_recp_return_invest";
    // 投资活动现金流入小计
    public static String stot_inflows_inv_act = "stot_inflows_inv_act";
    //购建固定资产、无形资产和其他长期资产支付的现金
    public static String c_pay_acq_const_fiolta = "c_pay_acq_const_fiolta";
    //处置固定资产、无形资产和其他长期资产收回的现金净额
    public static String n_recp_disp_fiolta = "n_recp_disp_fiolta";
    //投资支付的现金
    public static String c_paid_invest = "c_paid_invest";
    //投资活动现金流出小计
    public static String stot_out_inv_act = "stot_out_inv_act";
    //投资活动产生的现金流量净额
    public static String n_cashflow_inv_act = "n_cashflow_inv_act";
    // 吸收投资收到的现金
    public static String c_recp_cap_contrib = "c_recp_cap_contrib";
    // 取得借款收到的现金
    public static String c_recp_borrow = "c_recp_borrow";
    // 筹资活动现金流入小计
    public static String stot_cash_in_fnc_act = "stot_cash_in_fnc_act";
    // 偿还债务支付的现金
    public static String c_prepay_amt_borr = "c_prepay_amt_borr";
    // 分配股利、利润或偿付利息支付的现金
    public static String c_pay_dist_dpcp_int_exp = "c_pay_dist_dpcp_int_exp";
    // 筹资活动现金流出小计
    public static String stot_cashout_fnc_act = "stot_cashout_fnc_act";
    // 筹资活动产生的现金流量净额
    public static String n_cash_flows_fnc_act = "n_cash_flows_fnc_act";


    /***************************主要指标---财务指标数据*****************************/
    //基本每股收益
    public static String eps = "eps";
    //期末摊薄每股收益--扣非每股收益(无用)
    //public static String diluted2_eps;
    //稀释每股收益
    public static String dt_eps = "dt_eps";
    //每股净资产
    public static String bps = "bps";
    //每股资本公积
    public static String capital_rese_ps = "capital_rese_ps";
    //每股未分配利润
    public static String undist_profit_ps = "undist_profit_ps";
    //每股经营活动产生的现金流量净额--每股经营现金流
    public static String ocfps = "ocfps";
    // 营业收入
    //public static String revenue = "revenue";
    //归属净利润
    //public static String n_income_attr_p = "n_income_attr_p";
    //扣非净利润
    public static String profit_dedt = "profit_dedt";
    //营业收入同比增长(%)
    public static String or_yoy = "or_yoy";
    //营业收入同比增长率(%)(单季度)
    public static String q_sales_yoy = "q_sales_yoy";
    //归属净利润同比增长(%)
    public static String netprofit_yoy = "netprofit_yoy";
    //归属净利润同比增长(%)(单季度)
    public static String q_netprofit_yoy = "q_netprofit_yoy";
    //扣非净利润同比增长(%)
    public static String dtprofit_to_profit = "dtprofit_to_profit";
    //扣非净利润同比增长(%)(单季度)
    public static String q_dtprofit_to_profit = "q_dtprofit_to_profit";

    //加权净资产收益率-加权平均净资产收益率
    public static String roe_waa = "roe_waa";
    //摊薄净资产收益率-平均净资产收益率(增发条件)
    public static String roe_avg = "roe_avg";
    //净资产收益率
    public static String roe = "roe";
    //摊薄总资产收益率-年化总资产报酬率
    public static String roa2_yearly = "roa2_yearly";
    //总资产报酬率
    public static String roa = "roa";
    //销售毛利率
    public static String grossprofit_margin = "grossprofit_margin";
    //销售毛利率(单季度)
    public static String q_gsprofit_margin = "q_gsprofit_margin";
    //销售净利率
    public static String netprofit_margin = "netprofit_margin";
    //销售净利率(单季度)
    public static String q_netprofit_margin = "q_netprofit_margin";
    //实际税率
    //public static String sj_shuilv;

    //预期收益/营业收入(无用)
    //public static String yuq_profit_to_op;
    //销售现金流/营业收入--销售商品提供劳务收到的现金/营业收入
    public static String salescash_to_or = "salescash_to_or";
    //销售现金流/营业收入(单季度)
    public static String q_salescash_to_or = "q_salescash_to_or";
    //经营现金流/营业收入---经营活动产生的现金流量净额/营业收入
    public static String ocf_to_or = "ocf_to_or";
    //经营现金流/营业收入(单季度)---经营活动产生的现金流量净额/营业收入
    public static String q_ocf_to_or = "q_ocf_to_or";

    //总资产周转率(次)
    public static String assets_turn = "assets_turn";
    //应收账款周转天数(天)
    public static String arturn_days = "arturn_days";
    //存货周转天数(天)
    public static String invturn_days = "invturn_days";
    //资产负债率
    public static String debt_to_assets = "debt_to_assets";
    //流动负债/总负债
    public static String currentdebt_to_debt = "currentdebt_to_debt";
    //流动比率
    public static String current_ratio = "current_ratio";
    //速动比率
    public static String quick_ratio = "quick_ratio";


    public static List<String> stopStockFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.delist_date
    );

    public static List<String> suspendFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.suspend_date,
            TuFields.resume_date,
            TuFields.suspend_reason
    );

    public static List<String> dividenFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.ann_date,
            TuFields.div_proc,
            TuFields.stk_bo_rate,
            TuFields.stk_co_rate,
            TuFields.cash_div_tax,
            TuFields.record_date,
            TuFields.ex_date,
            TuFields.pay_date
    );

    public static List<String> stkHolderTradeFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.holder_name,
            TuFields.holder_type,
            TuFields.in_de,
            TuFields.change_vol,
            TuFields.change_ratio,
            TuFields.after_share,
            TuFields.after_ratio,
            TuFields.total_share,
            TuFields.begin_date
    );

    // 上市公司基本信息
    public static List<String> stockCompanyFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.reg_capital,
            TuFields.chairman,
            TuFields.setup_date,
            TuFields.province,
            TuFields.city,
            TuFields.introduction,
            TuFields.business_scope,
            TuFields.employees,
            TuFields.main_business
    );

    // 上市公司管理层
    public static List<String> stkManagersFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.name,
            TuFields.lev,
            TuFields.title,
            TuFields.edu,
            TuFields.national,
            TuFields.birthday,
            TuFields.begin_date
    );

    // IPO新股上市
    public static List<String> newShareFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.name,
            TuFields.ipo_date,
            TuFields.amount,
            TuFields.market_amount,
            TuFields.price,
            TuFields.limit_amount,
            TuFields.funds,
            TuFields.ballot
    );

    // 主营业务构成
    public static List<String> finaMainbzFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.bz_item,
            TuFields.bz_code,
            TuFields.bz_sales,
            TuFields.bz_profit,
            TuFields.bz_cost,
            TuFields.curr_type
    );


    // 基本信息
    public static List<String> bakBasicFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.float_share,
            TuFields.total_share,
            TuFields.total_assets,
            TuFields.liquid_assets,
            TuFields.fixed_assets,
            TuFields.reserved,
            TuFields.reserved_pershare,
            TuFields.undp,
            TuFields.per_undp,
            TuFields.rev_yoy,
            TuFields.profit_yoy,
            TuFields.gpr,
            TuFields.npr,
            TuFields.holder_num
    );

    // 财务指标数据
    public static List<String> finaIndicatorFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.end_date,
            TuFields.eps,
            TuFields.dt_eps,
            TuFields.bps,
            TuFields.capital_rese_ps,
            TuFields.undist_profit_ps,
            TuFields.ocfps,
            TuFields.profit_dedt,
            TuFields.or_yoy,
            TuFields.q_sales_yoy,
            TuFields.netprofit_yoy,
            TuFields.q_netprofit_yoy,
            TuFields.dtprofit_to_profit,
            TuFields.q_dtprofit_to_profit,
            TuFields.roe_waa,
            TuFields.roe_avg,
            TuFields.roe,
            TuFields.roa2_yearly,
            TuFields.roa,
            TuFields.grossprofit_margin,
            TuFields.q_gsprofit_margin,
            TuFields.netprofit_margin,
            TuFields.q_netprofit_margin,
            TuFields.salescash_to_or,
            TuFields.q_salescash_to_or,
            TuFields.ocf_to_or,
            TuFields.q_ocf_to_or,
            TuFields.assets_turn,
            TuFields.arturn_days,
            TuFields.invturn_days,
            TuFields.debt_to_assets,
            TuFields.currentdebt_to_debt,
            TuFields.current_ratio,
            TuFields.quick_ratio
    );

    // 利润表
    public static List<String> incomeFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.end_date,
            TuFields.total_revenue,
            TuFields.revenue,
            TuFields.total_cogs,
            TuFields.oper_exp,
            TuFields.sell_exp,
            TuFields.fin_exp,
            TuFields.admin_exp,
            TuFields.assets_impair_loss,
            TuFields.invest_income,
            TuFields.operate_profit,
            TuFields.income_tax,
            TuFields.n_income,
            TuFields.n_income_attr_p,
            TuFields.compr_inc_attr_p,
            TuFields.compr_inc_attr_m_s,
            TuFields.distr_profit_shrhder,
            TuFields.total_opcost
    );

    // 资产负债表
    public static List<String> balancesheetFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.end_date,
            TuFields.money_cap,
            TuFields.accounts_receiv,
            TuFields.inventories,
            TuFields.total_cur_assets,
            TuFields.lt_eqt_invest,
            TuFields.fix_assets,
            TuFields.intan_assets,
            TuFields.total_assets,
            TuFields.acct_payable,
            TuFields.adv_receipts,
            TuFields.total_cur_liab,
            TuFields.total_nca,
            TuFields.total_liab,
            TuFields.cap_rese,
            TuFields.surplus_rese,
            TuFields.total_hldr_eqy_inc_min_int
    );

    // 现金流量表
    public static List<String> cashflowFields = Arrays.asList(
            TuFields.ts_code,
            TuFields.end_date,
            TuFields.c_fr_sale_sg,
            TuFields.recp_tax_rends,
            TuFields.c_fr_oth_operate_a,
            TuFields.c_inf_fr_operate_a,
            TuFields.c_paid_goods_s,
            TuFields.c_paid_to_for_empl,
            TuFields.c_paid_for_taxes,
            TuFields.oth_cash_pay_oper_act,
            TuFields.st_cash_out_act,
            TuFields.n_cashflow_act,
            TuFields.c_recp_return_invest,
            TuFields.stot_inflows_inv_act,
            TuFields.c_pay_acq_const_fiolta,
            TuFields.n_recp_disp_fiolta,
            TuFields.n_recp_disp_fiolta,
            TuFields.c_paid_invest,
            TuFields.stot_out_inv_act,
            TuFields.n_cashflow_inv_act,
            TuFields.c_recp_cap_contrib,
            TuFields.c_recp_borrow,
            TuFields.stot_cash_in_fnc_act,
            TuFields.c_prepay_amt_borr,
            TuFields.c_pay_dist_dpcp_int_exp,
            TuFields.stot_cashout_fnc_act,
            TuFields.n_cash_flows_fnc_act
    );
}
