package com.shenhai.tech.market.project.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.cache.SessionCache;

import java.util.List;
import java.util.Map;


public class StockPush {
    public static void pushStockStatic(String data) {
        if(StringUtils.isEmpty(data)) {
            System.out.print("pushStockStatic socketClient count:"+SessionCache.socketClientMap.values().size()+" data is Empty \n");
            return;
        }
        //System.out.print("pushStockStatic socketClient count:"+ List.of(SessionCache.socketClientMap.keySet())+" \n");
        for (SocketIOClient socketIOClient : SessionCache.socketClientMap.values()) {
            socketIOClient.sendEvent(SocketEvent.stockStatic, data);
        }
    }

    public static void pushIndexQuotation(String data) {
        if(StringUtils.isEmpty(data)) {
            System.out.print("pushIndexQuotation socketClient count:"+SessionCache.socketClientMap.values().size()+" data is Empty \n");
            return;
        }
        //System.out.print("pushIndexQuotation socketClient count:"+SessionCache.socketClientMap.values().size()+" \n");
        for (SocketIOClient socketIOClient : SessionCache.socketClientMap.values()) {
            socketIOClient.sendEvent(SocketEvent.indexQuotation, data);
        }
    }

    public static void pushStockQuotation(String data) {
        if(StringUtils.isEmpty(data)) {
            System.out.print("pushStockQuotation socketClient count:"+SessionCache.socketClientMap.values().size()+" data is Empty \n");
            return;
        }
        //System.out.print("pushStockQuotation socketClient count:"+SessionCache.socketClientMap.values().size()+" \n");
        for (SocketIOClient socketIOClient : SessionCache.socketClientMap.values()) {
            socketIOClient.sendEvent(SocketEvent.stockQuotation, data);
        }
    }

    public static void pushStepTransaction(String data) {
        if(StringUtils.isEmpty(data)) {
            System.out.print("pushStepTransaction socketClient count:"+SessionCache.socketClientMap.values().size()+" data is Empty \n");
            return;
        }
        //System.out.print("pushStepTransaction socketClient count:"+SessionCache.socketClientMap.values().size()+" \n");
        for (SocketIOClient socketIOClient : SessionCache.socketClientMap.values()) {
            socketIOClient.sendEvent(SocketEvent.stepTransaction, data);
        }
    }

    public static void pushEntrustOrder(String data) {
        if(StringUtils.isEmpty(data)) {
            System.out.print("pushEntrustOrder socketClient count:"+SessionCache.socketClientMap.values().size()+" data is Empty \n");
            return;
        }
        //System.out.print("pushEntrustOrder socketClient count:"+SessionCache.socketClientMap.values().size()+" \n");
        for (SocketIOClient socketIOClient : SessionCache.socketClientMap.values()) {

            socketIOClient.sendEvent(SocketEvent.entrustOrder, data);
        }
    }

    public static void pushHeartBeat() {
        System.out.print("pushHeartBeat socketClient count:"+SessionCache.socketClientMap.values().size()+" \n");
        for (Map.Entry<String, SocketIOClient> entry : SessionCache.socketClientMap.entrySet()) {
            System.out.print("pushHeartBeat socketClient uuid:"+entry.getKey()+" \n");
            entry.getValue().sendEvent(SocketEvent.heartBeat, 1);
        }
    }
}
