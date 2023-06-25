
package com.shenhai.tech.market.project.queue;

import com.shenhai.tech.market.common.utils.TradingTimeUtils;
import com.shenhai.tech.market.project.cache.ConstantCache;
import com.shenhai.tech.market.project.process.StockProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class StockQuotasAutoHandleQueue {
    private static ScheduledExecutorService executors;
    @Autowired
    private StockProcess stockProcess;
    @PostConstruct
    public void init() {
        if(executors == null) {
            executors = Executors.newScheduledThreadPool(1);
        }
        StockQuotasAutoHandleQueue.executors.scheduleAtFixedRate(() -> {
            try {
                if (TradingTimeUtils.isRefreshQuotasV1(ConstantCache.getHolidays())) {
                    // 每分钟更新股票指标(耗时 1秒左右)
                    stockProcess.updateAllStockQuotas();
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                e.printStackTrace();
            }
        }, 6*1000, 30*1000, TimeUnit.MILLISECONDS);
    }

    public static void release() {
        log.info("release");
        executors.shutdown();
        executors = null;
    }
}
