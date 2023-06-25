package com.shenhai.tech.market.project.process;

import com.shenhai.tech.market.common.redis.RedisConstant;
import com.shenhai.tech.market.common.redis.RedisKey;
import com.shenhai.tech.market.common.redis.RedisService;
import com.shenhai.tech.market.common.utils.*;
import com.shenhai.tech.market.project.cache.ConstantCache;
import com.shenhai.tech.market.project.service.StockDayService;
import com.shenhai.tech.market.project.service.StockExRightsService;
import com.shenhai.tech.market.project.service.entity.StockExRights;
import com.shenhai.tech.market.project.strategy.MarketServer;
import com.shenhai.tech.market.project.strategy.cache.*;
import com.shenhai.tech.market.project.strategy.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


@Slf4j
@Component
public class StockProcess {
    @Autowired
    private MarketServer marketServer;
    @Autowired
    private RedisService redisService;
    @Autowired
    private StockDayService stockDayService;
    @Autowired
    private StockExRightsService stockExRightsService;

    //每天早上8:30点更新
    public void updateSuspensions() {
        try {
            if(!TradingTimeUtils.isTreadingDayV1(ConstantCache.getHolidays())) {
                log.info("非交易日,没有停牌数据数据,数据按照最后停牌日数据");
                return;
            }
            String date = LocalDateUtils.format(LocalDate.now(), LocalDateUtils.formatterDD3);
            String key = RedisKey.format(RedisConstant.MARKET_STOCK_SUSPENSION, date);
            List<Suspension> suspensions = marketServer.getSuspensionStocks(LocalDate.now());
            if (StringUtils.isNotEmpty(suspensions)) {
                // 存在在内存中
                SuspensionCache.put(date, suspensions);
                redisService.setCacheList(key, suspensions, 7, TimeUnit.DAYS);
            }
        } catch (Exception e) {
            log.error("updateSuspensions | 查询当前数据异常 |{}", e.getMessage());
        }

    }
    //每天早上8:30点更新
    public void updateDelistStocks() {
        if(!TradingTimeUtils.isTreadingDayV1(ConstantCache.getHolidays())) {
            log.info("非交易日,没有退市股票数据,数据按照最后退市日数据");
            return;
        }
        try {
            String date = LocalDateUtils.format(LocalDate.now(), LocalDateUtils.formatterDD3);
            String key = RedisKey.format(RedisConstant.MARKET_STOCK_DELIST, date);
            List<DelistStock> delistStocks = marketServer.getDelistStocks();
            if (StringUtils.isNotEmpty(delistStocks)) {
                // 存在在内存中
                DelistStockCache.put(date, delistStocks);
                redisService.setCacheList(key, delistStocks, 7, TimeUnit.DAYS);
            }
        } catch (Exception e) {
            log.error("updateDelistStocks | 查询当前数据异常 |{}", e.getMessage());
        }
    }
    //每天早上8:30点更新
    public void updateAllStocks(){
        try {
            long mils = System.currentTimeMillis();
            // 股票代码
            List<StockCode> stockCodes = marketServer.getAllStockCodes();

            Map<String, StockCode> stockCodeMap = StreamUtil.castMap(stockCodes, StockCode::getStockCode);
            // 停牌
            Map<String, Suspension>  suspensionMap = marketServer.getSuspensionStocksWithCache(LocalDate.now());
            // 退市
            Map<String, DelistStock>  delistStockMap = marketServer.getDelistStocksWithCache(LocalDate.now());
            // 所有指数
            List<Stock> indexs = marketServer.getAllIndexs();
            // 所有股票
            List<Stock> stocks = marketServer.getAllStocks();

            if(StringUtils.isEmpty(stocks)) {
                stocks = StockCache.getAllList();
                if (StringUtils.isEmpty(stocks)) {
                    Map<String, Stock> allStockMap = redisService.getCacheMap(RedisConstant.MARKET_STOCK_ALL);
                    if (StringUtils.isNotEmpty(allStockMap)) {
                        stocks = new ArrayList<>(allStockMap.values());
                    }
                }
            }

            if (StringUtils.isNotEmpty(stocks)) {
                // 存在在内存中
                for (Stock stock : stocks) {
                    // 是否停盘
                    stock.setIsSuspension(StringUtils.isNotEmpty(suspensionMap) && suspensionMap.containsKey(stock.getCode()));
                    // 是否退市
                    stock.setIsDelisting(StringUtils.isNotEmpty(delistStockMap) && delistStockMap.containsKey(stock.getCode()));
                    if(stockCodeMap.containsKey(stock.getCode())) {
                        StockCode stockCode = stockCodeMap.get(stock.getCode());
                        if(StringUtils.isNotEmpty(stockCode.getStockJaneSpell())) {
                            stock.setStockJaneSpell(stockCode.getStockJaneSpell());
                        }
                    }
                    StockCache.put(stock.getCode(), stock);
                }
            }

            // 更新指数
            if(StringUtils.isNotEmpty(indexs)) {
                for (Stock index : indexs) {
                    // 是否停盘
                    index.setIsSuspension(false);
                    // 是否退市
                    index.setIsDelisting(false);
                    // 更新涨跌停牌的个数
                    MarketBuilds.updateCount(index);
                    index.setStockJaneSpell(StockUtils.getStockJaneSpell(index.getCode()));
                    StockCache.put(index.getCode(), index);
                }
            }

            if(!StockCache.getAllMap().isEmpty() && StockCache.getAllMap().size() > 4500) {
                // 更新股票信息到缓存里
                redisService.setCacheMap(RedisConstant.MARKET_STOCK_ALL, StockCache.getAllMap());
                // 存入或者更新库
                stockDayService.insertOrUpdateBath(MarketBuilds.castStockDays(StockCache.getAllMap()));
            }
            log.info("updateAllStock allStock:{} 耗时:{}" , StockCache.getAllMap().size(), TimeUtils.getHMSTime(System.currentTimeMillis()-mils));
        } catch (Exception e) {
            log.error("updateAllStock | 查询当前数据异常 |{}", e.getMessage());
        }
    }
    // 同步除权除息
    public void updateStockExRights() {
        try {
            long mils = System.currentTimeMillis();
            if(StockCache.isEmpty()) {
                Map<String, Stock> allStockMap = redisService.getCacheMap(RedisConstant.MARKET_STOCK_ALL);
                if (StringUtils.isNotEmpty(allStockMap)) {
                    StockCache.putAll(allStockMap);
                }
            }

            List<Stock> stocks = StockCache.getAllList();
            if (StringUtils.isEmpty(stocks)) {
                log.info("updateStockExRights stocks isEmpty()");
                return;
            }

            for (Stock stock : stocks) {
                List<Dividend> dividends = marketServer.getDividendsByCode(stock.getCode());
                List<StockExRights> stockExRights = Dividend.cast(stock, dividends);
                if (StringUtils.isEmpty(stockExRights)) {
                    continue;
                }
                stockExRightsService.saveOrUpdateBatch(stockExRights);
                log.info("updateStockExRights ex_right stockExRightSize:{}, addStockExRightSize: {}", stockExRights.size(), JSONUtils.toJson(stockExRights));
                // 每100毫秒执行一次，每分钟600次，所有更新完需要10分钟
                Thread.sleep(200);
            }
            log.info("updateStockExRights 耗时:{}" , TimeUtils.getHMSTime(System.currentTimeMillis()-mils));
        } catch (Exception e) {
            log.error("updateStockExRights | 查询当前数据异常 |{}", e.getMessage());
        }
    }



    // 每分钟更新一次
    public void updateAllStockQuotas() {
        try {
            long mils = System.currentTimeMillis();
            List<StockQuota> stockQuotas = marketServer.getAllStockQuotas();
            if (StringUtils.isNotEmpty(stockQuotas)) {
                StockQuotaCache.putAll(stockQuotas);
                redisService.setCacheMap(RedisConstant.MARKET_STOCK_QUOTA, StockQuotaCache.getAllMap());
            }
            log.info("updateAllStockQuotas allStock:{} 耗时:{}" , StockCache.getAllMap().size(), TimeUtils.getHMSTime(System.currentTimeMillis()-mils));
        } catch (Exception e) {
            log.error("updateAllStockQuotas | 查询当前数据异常 |{}", e.getMessage());
        }
    }

    // 更新分时曲线
    public void updateRtMinuteKline() {
        try {
            if(StockCache.isEmpty()) {
                Map<String, Stock> allStockMap = redisService.getCacheMap(RedisConstant.MARKET_STOCK_ALL);
                if (StringUtils.isNotEmpty(allStockMap)) {
                    StockCache.putAll(allStockMap);
                }
            }

            List<Stock> stocks = StockCache.getAllList();
            if (StringUtils.isEmpty(stocks)) {
                log.info("updateRtMinuteKline stocks isEmpty()");
                return;
            }

            List<String> codes = new ArrayList<>();
            for (Stock stock : stocks) {
                codes.add(stock.getCode());
                if(codes.size() > 100) {
                    Map<String, List<RTKLine>> listMap = marketServer.getMinuteRealTimeKLines(codes);
                    RtKLineCache.putAll(listMap);
                    codes.clear();
                    Thread.sleep(10);
                }
            }

            if(StringUtils.isNotEmpty(codes)) {
                Map<String, List<RTKLine>> listMap = marketServer.getMinuteRealTimeKLines(codes);
                RtKLineCache.putAll(listMap);
            }
        } catch (Exception e) {
            log.error("updateRtMinuteKlineRedis 异常 {}", e.getMessage());
        }
    }

    public void clearRtMinutes() {
        // 清除内存
        RtKLineCache.clear();
    }

}
