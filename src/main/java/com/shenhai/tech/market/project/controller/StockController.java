package com.shenhai.tech.market.project.controller;

import com.shenhai.tech.market.common.response.APIResult;
import com.shenhai.tech.market.common.response.APIResultWrap;
import com.shenhai.tech.market.common.utils.GZIPUtils;
import com.shenhai.tech.market.common.utils.JSONUtils;
import com.shenhai.tech.market.project.controller.param.CodesParam;
import com.shenhai.tech.market.project.service.StockExRightsService;
import com.shenhai.tech.market.project.service.entity.StockExRights;
import com.shenhai.tech.market.project.strategy.MarketServer;
import com.shenhai.tech.market.project.strategy.entity.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {
    @Autowired
    private MarketServer marketServer;
    @Autowired
    private StockExRightsService stockExRightsService;

    @ApiOperation(value = "今日获取所有停牌股票")
    @PostMapping("/getAllSuspensions")
    public APIResult<String> getAllSuspensions() {
        Map<String, Suspension>  suspensionMap = marketServer.getSuspensionStocksWithCache(LocalDate.now());
        String dataStr = JSONUtils.toJson(suspensionMap);
        String compress =  Base64.getEncoder().encodeToString(GZIPUtils.compress(dataStr));
        return APIResultWrap.ok(compress);
    }

    @ApiOperation(value = "今日获取所有退市股票")
    @PostMapping("/getAllDelistStocks")
    public APIResult<String> getAllDelistStocks() {
        Map<String, DelistStock>  delistStockMap = marketServer.getDelistStocksWithCache(LocalDate.now());
        String dataStr = JSONUtils.toJson(delistStockMap);
        String compress =  Base64.getEncoder().encodeToString(GZIPUtils.compress(dataStr));
        return APIResultWrap.ok(compress);
    }

    @ApiOperation(value = "获取所有股票指数")
    @PostMapping("/getAllStockQuotas")
    public APIResult<String> getAllStockQuotas() {
        List<StockQuota> stockQuotas = marketServer.getAllStockQuotasWithCache();
        String dataStr = JSONUtils.toJson(stockQuotas);
        String compress =  Base64.getEncoder().encodeToString(GZIPUtils.compress(dataStr));
        return APIResultWrap.ok(compress);
    }

    @ApiOperation(value = "获取所有股票的分时曲线指数")
    @PostMapping("/getAllRtMinuteKlineCompress")
    public APIResult<String> getAllRtMinuteKlineCompress() {
        String compress = marketServer.getAllRtMinuteKlineCompressWithCache();
        return APIResultWrap.ok(compress);
    }

    @ApiOperation(value = "获取所有股票的分时曲线指数")
    @PostMapping("/getRtMinuteKlines")
    public APIResult<String> getRtMinuteKlines(@RequestBody CodesParam param) {
        Map<String,  List<RTKLine>> map = marketServer.getRtMinuteKlinesWithCache(param.getCodes());
        String dataStr = JSONUtils.toJson(map);
        String compress =  Base64.getEncoder().encodeToString(GZIPUtils.compress(dataStr));
        return APIResultWrap.ok(compress);
    }

    @ApiOperation(value = "获取所有股票的分时曲线指数")
    @PostMapping("/getRtMinuteKline")
    public APIResult<List<RTKLine>> getRtMinuteKline(@RequestParam("code") String code) {
        return APIResultWrap.ok(marketServer.getRtMinuteKlineWithCache(code));
    }


    @ApiOperation(value = "获取某只股票的除权除息信息")
    @PostMapping("/getDividendsByCode")
    public APIResult<List<Dividend>> getDividendsByCode(@RequestParam("code") String code) {
        List<StockExRights> stockExRights = stockExRightsService.getDividendsByCode(code);
        return APIResultWrap.ok(Dividend.castDividends(stockExRights));
    }

    @ApiOperation(value = "获取某只股票的除权除息信息")
    @PostMapping("/getDividendsByDay")
    public APIResult<List<Dividend>> getDividendsByDay(@RequestParam("days") Integer days) {
        List<StockExRights> stockExRights = stockExRightsService.getDividendsByDay(days);
        return APIResultWrap.ok(Dividend.castDividends(stockExRights));
    }
}
