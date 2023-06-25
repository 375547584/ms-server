package com.shenhai.tech.market.project.strategy.entity;

import com.shenhai.tech.market.common.utils.TimeUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class QHKData {
    private String date;   //	交易日期
    private BigDecimal open;   //	开盘价
    private BigDecimal high;   //	最高价
    private BigDecimal low;   //	最低价
    private BigDecimal close;   //	收盘价
    private BigDecimal yclose;   //前收盘价
    private Long vol;   //	成交量
    private BigDecimal amount;   //成交额
    private Long capital;   //流通股本
    private BigDecimal flowmarketvalue;   //流通市值
    private BigDecimal exchangerate;   //	换手率

    public static List<String> cast(QHKData qhkData) {
        List<String> kLineData = new ArrayList<>();
        String date = TimeUtils.getDate(qhkData.getDate());
        String time = TimeUtils.getTime(qhkData.getDate());
        kLineData.add(date);
        kLineData.add(qhkData.yclose.toString());
        kLineData.add(qhkData.open.toString());
        kLineData.add(qhkData.high.toString());
        kLineData.add(qhkData.low.toString());
        kLineData.add(qhkData.close.toString());
        kLineData.add(qhkData.vol.toString());
        kLineData.add(qhkData.amount.toString());
        kLineData.add(time);
        return kLineData;
    }
}
