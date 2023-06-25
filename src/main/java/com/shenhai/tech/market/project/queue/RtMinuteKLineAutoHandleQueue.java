
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
public class RtMinuteKLineAutoHandleQueue {
    private static ScheduledExecutorService executors;
    @Autowired
    private StockProcess stockProcess;

    @PostConstruct
    public void init() {
        if(executors == null) {
            executors = Executors.newScheduledThreadPool(1);
        }
        RtMinuteKLineAutoHandleQueue.executors.scheduleAtFixedRate(() -> {
            try {
                if (TradingTimeUtils.isRtMinuteTimeV1(ConstantCache.getHolidays())) {
                    // 更新分时曲线(耗时1分钟左右)
                    stockProcess.updateRtMinuteKline();
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                e.printStackTrace();
            }
        }, 6*1000, 60*1000, TimeUnit.MILLISECONDS);
    }

    public static void release() {
        log.info("release");
        executors.shutdown();
        executors = null;
    }
}
