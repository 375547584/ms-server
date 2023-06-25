package com.shenhai.tech.market.project.strategy.socket;

import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.socket.StockPush;
import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;


public class QTSSocket {

    private static Socket socket;
    private static String socketUrl;
    private static String clientNo;
    private static long heartBeatMilsec = System.currentTimeMillis();

    public static long getHeartBeatMilsec() {
        return heartBeatMilsec;
    }

    public static void setUrl(String url, String clientNo) {
        QTSSocket.socketUrl =  url;
        QTSSocket.clientNo = clientNo;
    }

    public static void connect(String url, String clientNo) {
        if(StringUtils.isNotEmpty(url) && StringUtils.isNotEmpty(clientNo)) {
            QTSSocket.socketUrl =  url;
            QTSSocket.clientNo = clientNo;
        }

        try {
            IO.Options options = new IO.Options();
            options.transports = new String[]{"websocket"};
            options.reconnectionAttempts = 2;
            // 失败重连的时间间隔
            options.reconnectionDelay = 1000;
            // 连接超时时间(ms)
            options.timeout = 500;
            // userId: 唯一标识 传给服务端存储
            socket = IO.socket(QTSSocket.socketUrl+"?clientNo="+QTSSocket.clientNo, options);
        } catch (URISyntaxException e) {
            System.out.print("QTSSocket soekct服务链接异常"+ e.getMessage()+ " \n");
        }

        if(socket == null) {
            return;
        }

        // 自定义事件`connected` -> 接收服务端成功连接消息
        socket.on(SocketEvent.stockStatic, objects -> {
            String data = objects[0].toString();
            StockPush.pushStockStatic(data);
            heartBeatMilsec = System.currentTimeMillis();
        });
        socket.on(SocketEvent.indexQuotation, objects -> {
            String data = objects[0].toString();
            StockPush.pushIndexQuotation(data);
            heartBeatMilsec = System.currentTimeMillis();
        });
        socket.on(SocketEvent.stockQuotation, objects -> {
            String data = objects[0].toString();
            StockPush.pushStockQuotation(data);
            heartBeatMilsec = System.currentTimeMillis();
        });
        socket.on(SocketEvent.stepTransaction, objects -> {
            String data = objects[0].toString();
            StockPush.pushStepTransaction(data);
            heartBeatMilsec = System.currentTimeMillis();
        });
        socket.on(SocketEvent.entrustOrder, objects -> {
            String data = objects[0].toString();
            StockPush.pushEntrustOrder(data);
            heartBeatMilsec = System.currentTimeMillis();
        });
        socket.on(SocketEvent.heartBeat, objects -> {
            System.out.print("QTSSocket 服务端 heartBeat \n");
            heartBeatMilsec = System.currentTimeMillis();
        });

        socket.connect();

        System.out.print("QTSSocket connect \n");
    }

    public static void disConnect() {
        if(socket != null) {
            socket.disconnect();
            socket = null;
            System.out.print("QTSSocket disConnect \n");
        }

    }
}
