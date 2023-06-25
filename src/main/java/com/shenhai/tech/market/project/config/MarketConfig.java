package com.shenhai.tech.market.project.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MarketConfig {

    @Value("${spring.profiles.active}")
    public String env;

    @Value("${market.holidays}")
    public String holidays;


    @Value("${market.stock.realtime}")
    public String realtime;


    /**********挖地兔**********/
    @Value("${market.stock.tu.tushareUrl}")
    public String tushareUrl;
    @Value("${market.stock.tu.tushareToken}")
    public String tushareToken;


    @Value("${market.stock.qts.domain}")
    public String gtaDomain;
    @Value("${market.stock.qts.socket_domain}")
    public String qtsSocketDomain;
    @Value("${market.stock.qts.client_no}")
    public String clientNo;



    @Value("${market.stock.zlqh.domain}")
    public String qhDomain;
    @Value("${market.stock.zlqh.path.stock}")
    public String qhStock;
    @Value("${market.stock.zlqh.path.stock_price}")
    public String qhStockPrice;
    @Value("${market.stock.zlqh.path.block_list}")
    public String qhBlockList;
    @Value("${market.stock.zlqh.path.block_stock_list}")
    public String qhBlockStockList;
    @Value("${market.stock.zlqh.path.k_line}")
    public String qhKLine;
    @Value("${market.stock.zlqh.path.k_realtime_line}")
    public String qhKRealtimeLine;
    @Value("${market.stock.zlqh.path.item_by_deal}")
    public String qhItemByDeal;
    @Value("${market.stock.zlqh.path.his_item_by_deal}")
    public String qhHisItemByDeal;
    @Value("${market.stock.zlqh.path.stock_dividend_list}")
    public String qhStockDividendList;
}
