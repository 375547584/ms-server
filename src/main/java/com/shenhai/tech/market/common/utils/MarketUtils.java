package com.shenhai.tech.market.common.utils;

import com.shenhai.tech.market.project.strategy.entity.Index;
import com.shenhai.tech.market.project.strategy.entity.Stock;
import com.shenhai.tech.market.project.strategy.zlhq.entity.QHStock;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MarketUtils {

    public static boolean checkStock(Stock stock) {
        if(stock == null) {
            return false;
        }

        // 当前价格为小于等于0
        if (BigDecimalUtil.ltZero(stock.getPrice())) {
            log.error("当前股票{} 价格异常, 价格为:{} 不符合卖出要求", stock.getName(), stock.getPrice());
            return false;
        }

        if (BigDecimalUtil.ltZero(stock.getRiseStopPrice()) || BigDecimalUtil.ltZero(stock.getFallStopPrice())) {
            log.error("当前股票{} 价格异常, 最高和最低加个小于等于0 不符合卖出要求", stock.getName());
            return false;
        }

        return true;
    }

    public static boolean checkStock(QHStock qhStock) {
        if(qhStock == null) {
            return false;
        }

        // 当前价格为小于等于0
        if (BigDecimalUtil.ltZero(qhStock.getPrice())) {
            log.error("当前股票{} 价格异常, 价格为:{} 不符合卖出要求", qhStock.getName(), qhStock.getPrice());
            return false;
        }

        if (BigDecimalUtil.ltZero(qhStock.getUplimit()) || BigDecimalUtil.ltZero(qhStock.getDnlimit())) {
            log.error("当前股票{} 价格异常, 最高和最低加个小于等于0 不符合卖出要求", qhStock.getName());
            return false;
        }

        return true;
    }

    public static boolean checkIndex(Index index) {
        if(index == null) {
            return false;
        }

        // 当前价格为小于等于0
        if (BigDecimalUtil.ltZero(index.getPrice())) {
            log.error("当前股票{} 价格异常, 价格为:{} 不符合卖出要求", index.getName(), index.getPrice());
            return false;
        }

        return true;
    }
}
