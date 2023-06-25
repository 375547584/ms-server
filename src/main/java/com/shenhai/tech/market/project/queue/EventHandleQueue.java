
package com.shenhai.tech.market.project.queue;

import com.shenhai.tech.market.project.process.StockProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

@Slf4j
@Component
public class EventHandleQueue {
    private static BlockingQueue<String> QUEUE = new LinkedBlockingQueue<>();
    private static ScheduledExecutorService executors;
    @Autowired
    private StockProcess stockProcess;

    @PostConstruct
    public void init() {
        if(executors == null) {
            executors = Executors.newScheduledThreadPool(1);
        }
        if(QUEUE == null) {
            QUEUE = new LinkedBlockingQueue<>();
        }
        EventHandleQueue.executors.scheduleAtFixedRate(() -> {
            try {
                String queueEvent = EventHandleQueue.QUEUE.take();
                log.info("更新开始: {}", queueEvent);
                if (Event.updateSuspensions.equals(queueEvent)) {
                    stockProcess.updateSuspensions();
                }
                else if (Event.updateDelistStocks.equals(queueEvent)) {
                    stockProcess.updateDelistStocks();
                }
                else if (Event.updateAllStocks.equals(queueEvent)) {
                    stockProcess.updateAllStocks();
                }
                else if(Event.updateRtMinuteKline.equals(queueEvent)) {
                    stockProcess.updateRtMinuteKline();
                }
                else if(Event.updateStockExRights.equals(queueEvent)) {
                    stockProcess.updateStockExRights();
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                e.printStackTrace();
            }
        }, 5*1000, 100, TimeUnit.MILLISECONDS);
    }

    public static void produce(String queueEvent) {
        if(!QUEUE.contains(queueEvent)) {
            QUEUE.add(queueEvent);
        }
    }

    public static void release() {
        log.info("release");
        executors.shutdown();
        executors = null;
    }
}
