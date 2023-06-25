
package com.shenhai.tech.market.project.queue;

import com.shenhai.tech.market.project.cache.ConstantCache;
import com.shenhai.tech.market.project.config.MarketConfig;
import com.shenhai.tech.market.project.strategy.socket.QTSSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CheckHeartBeatAutoHandleQueue {
    private static ScheduledExecutorService executors;
    @Autowired
    private MarketConfig marketConfig;

    @PostConstruct
    public void init() {
        if(executors == null) {
            executors = Executors.newScheduledThreadPool(1);
        }
        CheckHeartBeatAutoHandleQueue.executors.scheduleAtFixedRate(() -> {
            //更新节假日
            ConstantCache.setHolidays(marketConfig.holidays);
            //更新实时数据来源
            ConstantCache.setRealtime(marketConfig.realtime);

            //心跳检测
            long delay = System.currentTimeMillis() - QTSSocket.getHeartBeatMilsec();
            //log.info("QTSSocket 心跳时间 delay:"+delay);
            if(delay >= 3000 ) {
                try {
                    QTSSocket.connect(marketConfig.qtsSocketDomain, marketConfig.clientNo);
                } catch (Exception e) {
                    log.error("QTSSocket marketConfig.qtsSocketDomain:{} marketConfig.clientNo {}", marketConfig.qtsSocketDomain, marketConfig.clientNo);
                    e.printStackTrace();
                }
                log.error("QTSSocket 心跳时间 delay:{} 开始链接Socket",delay);
            }
        }, 5*1000, 1000, TimeUnit.MILLISECONDS);
    }

    public static void release() {
        log.info("release");
        executors.shutdown();
        executors = null;
    }
}
