package com.shenhai.tech.market.project.controller;

import com.shenhai.tech.market.common.response.APIResult;
import com.shenhai.tech.market.common.response.APIResultWrap;
import com.shenhai.tech.market.project.strategy.MarketServer;
import com.shenhai.tech.market.project.strategy.entity.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private MarketServer marketServer;

    @ApiOperation(value = "今日获取所有停牌股票")
    @PostMapping("/getAllSuspensions")
    public APIResult<Map<String, Suspension>> getAllSuspensions() {
        Map<String, Suspension>  suspensionMap = marketServer.getSuspensionStocksWithCache(LocalDate.now());
        return APIResultWrap.ok(suspensionMap);
    }

    @ApiOperation(value = "今日获取所有退市股票")
    @PostMapping("/getAllDelistStocks")
    public APIResult<Map<String, DelistStock>> getAllDelistStocks() {
        Map<String, DelistStock>  delistStockMap = marketServer.getDelistStocksWithCache(LocalDate.now());
        return APIResultWrap.ok(delistStockMap);
    }

    @ApiOperation(value = "获取所有股票指数")
    @PostMapping("/getAllStockQuotas")
    public APIResult<List<StockQuota>> getAllStockQuotas() {
        List<StockQuota> stockQuotas = marketServer.getAllStockQuotasWithCache();
        return APIResultWrap.ok(stockQuotas);
    }

    @ApiOperation(value = "获取所有股票的分时曲线指数")
    @PostMapping("/getRtMinuteKline")
    public APIResult<List<RTKLine>> getRtMinuteKline(@RequestParam("code") String code) {
        return APIResultWrap.ok(marketServer.getRtMinuteKlineWithCache(code));
    }

    @ApiOperation(value = "获取所有股票的分时曲线指数")
    @PostMapping("/getStock")
    public APIResult<Stock> getStock(@RequestParam("code") String code) {
        return APIResultWrap.ok(marketServer.getAllStockWithCache(code));
    }
}
