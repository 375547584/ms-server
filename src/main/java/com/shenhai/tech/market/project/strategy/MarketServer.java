package com.shenhai.tech.market.project.strategy;

import com.shenhai.tech.market.common.redis.RedisConstant;
import com.shenhai.tech.market.common.redis.RedisKey;
import com.shenhai.tech.market.common.redis.RedisService;
import com.shenhai.tech.market.common.utils.*;
import com.shenhai.tech.market.project.service.entity.StockExRights;
import com.shenhai.tech.market.project.strategy.cache.*;
import com.shenhai.tech.market.project.strategy.entity.*;
import com.shenhai.tech.market.project.strategy.zlhq.HQMarketServer;
import com.shenhai.tech.market.project.strategy.tu.TuShareMarketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MarketServer {
    @Autowired
    private RedisService redisService;
    @Autowired
    private HQMarketServer hqMarketServer;
    @Autowired
    private TuShareMarketServer tuShareMarketServer;


    /**
     * 获取所有停牌股票，带缓存
     * @return
     */
    public Map<String, Suspension> getSuspensionStocksWithCache(LocalDate suspensionDate) {
        try {
            if (StringUtils.isNull(suspensionDate)) {
                return null;
            }
            String date = LocalDateUtils.format(suspensionDate, LocalDateUtils.formatterDD3);
            String key = RedisKey.format(RedisConstant.MARKET_STOCK_SUSPENSION, date);
            if (!SuspensionCache.containsKey(date)) {
                if(redisService.hasKey(key)){
                    List<Suspension> suspensions = redisService.getCacheList(key);
                    if (StringUtils.isNotEmpty(suspensions)) {
                        // 存在在内存中
                        SuspensionCache.put(date, suspensions);
                    }
                }
            }

            if (!SuspensionCache.containsKey(date)) {
                List<Suspension> suspensions = getSuspensionStocks(suspensionDate);
                if (StringUtils.isNotEmpty(suspensions)) {
                    // 存在在内存中
                    SuspensionCache.put(date, suspensions);
                    redisService.setCacheList(key, suspensions, 7, TimeUnit.DAYS);
                }
            }

            List<Suspension> suspensions = SuspensionCache.get(date);
            return StreamUtil.castMap(suspensions, Suspension::getStockCode);
        }
        catch (Exception e) {
            log.error("getSuspensionStocksWithCache 接口异常{}", e.getMessage());
        }
        return null;
    }

    /**
     * 获取所有退市股票，带缓存
     * @return
     */
    public Map<String, DelistStock> getDelistStocksWithCache(LocalDate sdate) {
        try {
            String date = LocalDateUtils.format(sdate, LocalDateUtils.formatterDD3);
            String key = RedisKey.format(RedisConstant.MARKET_STOCK_DELIST, date);
            if (!DelistStockCache.containsKey(date)) {
                List<DelistStock> delistStocks = redisService.getCacheList(key);
                if (StringUtils.isNotEmpty(delistStocks)) {
                    // 存在在内存中
                    DelistStockCache.put(date, delistStocks);
                }
            }
            if (!DelistStockCache.containsKey(date)) {
                List<DelistStock> delistStocks = getDelistStocks();
                if (StringUtils.isNotEmpty(delistStocks)) {
                    // 存在在内存中
                    DelistStockCache.put(date, delistStocks);
                    redisService.setCacheList(key, delistStocks, 7, TimeUnit.DAYS);
                }
            }
            List<DelistStock> delistStocks = DelistStockCache.get(date);
            return StreamUtil.castMap(delistStocks, DelistStock::getStockCode);
        }
        catch (Exception e) {
            log.error("getDelistStocksWithCache 接口异常{}", e.getMessage());
        }
        return new HashMap<>();
    }


/*******************每天数据************************************************/

    /**
     * 获取所有股票
     * @return
     */
    public List<Stock> getAllStocks() {
        try {
            List<Stock> stocks = hqMarketServer.getAllStock();
            if(StringUtils.isNotEmpty(stocks)) {
                return stocks;
            }

            // TODO：从第二渠道查询

            // TODO：第三渠道查询

            return stocks;
        }
        catch (Exception e) {
            log.error("getAllStocks 接口异常{}", e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * 获取所有指数
     * @return
     */
    public List<Stock> getAllIndexs() {
        try {
            List<Stock> indexs =  hqMarketServer.getAllIndexs();
            if(StringUtils.isNotEmpty(indexs)) {
                return indexs;
            }

            // TODO：从第二渠道查询

            // TODO：第三渠道查询

            return indexs;
        }
        catch (Exception e) {
            log.error("getAllIndexs 接口异常{}", e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * 获取所有股票简码
     * @return
     */
    public List<StockCode> getAllStockCodes() {
        try {
            List<StockCode> stockCodes = hqMarketServer.getAllStockCodes();
            if(StringUtils.isNotEmpty(stockCodes)) {
                return stockCodes;
            }

            // TODO：从第二渠道查询

            // TODO：第三渠道查询

            return stockCodes;
        }
        catch (Exception e) {
            log.error("getAllStockCodes 接口异常{}", e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * 获取所有停牌股票
     * @return
     */
    public List<Suspension> getSuspensionStocks(LocalDate suspensionDate) {
        // 从挖地兔查询
        List<Suspension> suspensions = tuShareMarketServer.getSuspensionStocks(suspensionDate);
        if(StringUtils.isNotEmpty(suspensions)) {
            return suspensions;
        }

        // TODO：从第二渠道查询

        // TODO：第三渠道查询

        return suspensions;
    }

    /**
     * 获取所有退市股票
     * @return
     */
    public List<DelistStock> getDelistStocks() {
        // 从挖地兔查询
        List<DelistStock> delistStocks = tuShareMarketServer.getDelistStocks();
        if(StringUtils.isNotEmpty(delistStocks)) {
            return delistStocks;
        }

        // TODO：从第二渠道查询

        // TODO：第三渠道查询

        return delistStocks;
    }

/*******************分钟数据************************************************/
    public String getAllRtMinuteKlineCompressWithCache() {
        return RtKLineCache.getCompress();
    }

    public Map<String, List<RTKLine>> getRtMinuteKlinesWithCache(List<String> codes) {
        return RtKLineCache.get(codes);
    }

    public List<RTKLine> getRtMinuteKlineWithCache(String code) {
        return RtKLineCache.get(code);
    }

    public List<StockQuota> getAllStockQuotasWithCache() {
        if(StockQuotaCache.isEmpty()) {
            Map<String, StockQuota> allMap = redisService.getCacheMap(RedisConstant.MARKET_STOCK_QUOTA);
            if (StringUtils.isNotEmpty(allMap)) {
                StockQuotaCache.putAll(allMap);
            }
            else {
                List<StockQuota> stockQuotas = getAllStockQuotas();
                if(StringUtils.isNotEmpty(stockQuotas)) {
                    StockQuotaCache.putAll(stockQuotas);
                    redisService.setCacheMap(RedisConstant.MARKET_STOCK_QUOTA, StockQuotaCache.getAllMap());
                }
            }
        }
        return StockQuotaCache.getAllList();
    }

    /**
     * 所有股票指标
     * @return
     */
    public List<StockQuota> getAllStockQuotas() {
        List<StockQuota> stockQuotas = hqMarketServer.getAllStockQuotas();
        if(StringUtils.isNotEmpty(stockQuotas)) {
            return stockQuotas;
        }

        // TODO：从第二渠道查询

        // TODO：第三渠道查询

        return stockQuotas;
    }

    /**
     * 批量获取分时曲线
     * @param codes
     * @return
     */
    public Map<String, List<RTKLine>> getMinuteRealTimeKLines(List<String> codes) {
        return hqMarketServer.getMinuteRealTimeKLines(codes);
    }

    public Stock getAllStockWithCache(String code) {
        if (StockCache.isEmpty()) {
            Map<String, Stock> allStockMap = redisService.getCacheMap(RedisConstant.MARKET_STOCK_ALL);
            if (StringUtils.isNotEmpty(allStockMap)) {
                StockCache.putAll(allStockMap);
            }
        }
        return StockCache.get(code);
    }

    public List<Dividend> getDividendsByCode(String code) {
        try {
            List<Dividend> tuDividends = tuShareMarketServer.getDividendsByCode(code);
            List<Dividend> hqDividends = hqMarketServer.getDividendsByCode(code);
            if(StringUtils.isEmpty(hqDividends) && StringUtils.isEmpty(tuDividends)) {
                return new ArrayList<>();
            }
            if(StringUtils.isEmpty(hqDividends)) {
                return tuDividends;
            }
            if(StringUtils.isEmpty(tuDividends)) {
                return hqDividends;
            }
            Map<String, Dividend> tuDividendMap = StreamUtil.castMap(tuDividends, Dividend::getUniqueId);
            for (Dividend dividend : hqDividends) {
                if(!tuDividendMap.containsKey(dividend.getUniqueId())) {
                    tuDividends.add(dividend);
                }
            }
            return new ArrayList<>(tuDividendMap.values());
        }
        catch (Exception e) {
            log.error("getDividendsByCode Exception code:{}  e:{}", code, e);
        }
        return Collections.emptyList();
    }
}
