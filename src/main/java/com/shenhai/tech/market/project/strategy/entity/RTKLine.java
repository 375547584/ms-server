package com.shenhai.tech.market.project.strategy.entity;

import com.shenhai.tech.market.common.utils.LocalDateUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class RTKLine {
    //时间 925/1025
    private String time;
    // 当前价格
    private BigDecimal price;
    // 均价
    private BigDecimal avPrice;
    //成交量
    private Long vol;
    // 成交额
    private BigDecimal amount;
    // 涨跌幅
    private BigDecimal increase;
    // 涨跌额
    private BigDecimal riseFall;

    private String date;

    private BigDecimal open;

    private BigDecimal high;

    private BigDecimal low;


    public static List<RTKLine> zeros() {
        List<RTKLine> rtkLineS = new ArrayList<>();
        rtkLineS.add(RTKLine.zero());
        return rtkLineS;
    }

    private static RTKLine zero() {
        RTKLine rtkLine = new RTKLine();
        rtkLine.setTime("0930");
        rtkLine.setDate(LocalDateUtils.format(LocalDate.now(), LocalDateUtils.formatterDD3));
        rtkLine.setOpen(BigDecimal.ZERO);
        rtkLine.setHigh(BigDecimal.ZERO);
        rtkLine.setLow(BigDecimal.ZERO);
        rtkLine.setPrice(BigDecimal.ZERO);
        rtkLine.setAvPrice(BigDecimal.ZERO);
        rtkLine.setVol(0L);
        rtkLine.setAmount(BigDecimal.ZERO);
        rtkLine.setIncrease(BigDecimal.ZERO);
        rtkLine.setRiseFall(BigDecimal.ZERO);
        return rtkLine;
    }

    public static Map<String, List<RTKLine>> zeros(List<String> codes) {
        Map<String, List<RTKLine>> map = new HashMap<>();
        for (String code :codes) {
            List<RTKLine> rtkLineS = RTKLine.zeros();
            map.put(code, rtkLineS);
        }
        return map;
    }
}
