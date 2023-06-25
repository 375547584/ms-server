package com.shenhai.tech.market.project.runner;

import com.shenhai.tech.market.project.queue.*;
import com.shenhai.tech.market.project.strategy.socket.QTSSocket;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;


@Component
public class StopRunner implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("----------SpringBoot停止前释放资源-------------");
        try {
            CheckHeartBeatAutoHandleQueue.release();
            EventHandleQueue.release();
            RtMinuteKLineAutoHandleQueue.release();
            StockQuotasAutoHandleQueue.release();
            QTSSocket.disConnect();
        }
        catch (Exception e) {
            System.out.println("destroy失败");
        }
    }

}