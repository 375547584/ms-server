package com.shenhai.tech.market.project.runner;

import com.shenhai.tech.market.common.redis.RedisConstant;
import com.shenhai.tech.market.common.redis.RedisService;
import com.shenhai.tech.market.common.utils.TradingTimeUtils;
import com.shenhai.tech.market.project.config.MarketConfig;
import com.shenhai.tech.market.project.cache.ConstantCache;
import com.shenhai.tech.market.project.queue.Event;
import com.shenhai.tech.market.project.queue.EventHandleQueue;
import com.shenhai.tech.market.project.strategy.socket.QTSSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunnner implements ApplicationRunner {

    @Autowired
    protected MarketConfig marketConfig;
    @Autowired
    protected RedisService redisService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("----------SpringBoot启动完成之后再做一些自己的业务-------------");
        //更新节假日
        ConstantCache.setHolidays(marketConfig.holidays);
        //更新实时数据来源
        ConstantCache.setRealtime(marketConfig.realtime);

        QTSSocket.setUrl(marketConfig.qtsSocketDomain, marketConfig.clientNo);

        if(TradingTimeUtils.isTreadingDayV1(ConstantCache.getHolidays())) {
            EventHandleQueue.produce(Event.updateSuspensions);
            EventHandleQueue.produce(Event.updateDelistStocks);
            EventHandleQueue.produce(Event.updateAllStocks);
        }

        EventHandleQueue.produce(Event.updateRtMinuteKline);

        EventHandleQueue.produce(Event.updateStockExRights);
    }
}
