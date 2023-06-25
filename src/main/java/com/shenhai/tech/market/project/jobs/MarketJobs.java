package com.shenhai.tech.market.project.jobs;

import com.shenhai.tech.market.common.utils.TradingTimeUtils;
import com.shenhai.tech.market.project.cache.ConstantCache;
import com.shenhai.tech.market.project.process.StockProcess;
import com.shenhai.tech.market.project.queue.Event;
import com.shenhai.tech.market.project.queue.EventHandleQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
public class MarketJobs {
    @Autowired
    private StockProcess stockProcess;

    /**
     * CRON：0 0 5 ? * MON-FRI
     * 每天早上5点更新退市和停盘的股票
     */
    @Scheduled(cron = "0 1 5,6,7,8,9 ? * MON-FRI")
    public void updateCacheJob() {
        // 节假日
        if (TradingTimeUtils.isTreadingDayV1(ConstantCache.getHolidays())) {
            // 更新停牌的股票
            stockProcess.updateSuspensions();
            // 更新退市股票
            stockProcess.updateDelistStocks();
            // 更新所有股票Code
            stockProcess.updateAllStocks();
        }
    }


    /**
     * CRON：0 0 5,22 ? * MON-FRI
     * 每天早上5和晚上10点更新除权除息
     */
    @Scheduled(cron = "0 0 4,22 ? * MON-FRI")
    public void updateStockExRightsJob() {
        // 节假日
        if (TradingTimeUtils.isTreadingDayV1(ConstantCache.getHolidays())) {
            // 更新除权除息
            EventHandleQueue.produce(Event.updateStockExRights);
        }
    }

    /**
     * CRON：0 0 5 ? * MON-FRI
     * 每天早上9:05 9:06 9:07点更新退市和停盘的股票
     */
    @Scheduled(cron = "0 5,6,7,8,9,10,10,11,12,13,14 9 ? * MON-FRI")
    public void clearCacheJob() {
        // 节假日
        if (TradingTimeUtils.isTreadingDayV1(ConstantCache.getHolidays())) {
            // 清分时曲线
            stockProcess.clearRtMinutes();
        }
    }
}
