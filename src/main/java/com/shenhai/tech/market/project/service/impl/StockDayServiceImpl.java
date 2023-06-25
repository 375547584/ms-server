package com.shenhai.tech.market.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shenhai.tech.market.common.utils.StringUtils;
import com.shenhai.tech.market.project.service.StockDayService;
import com.shenhai.tech.market.project.service.mapper.StockDayMapper;
import com.shenhai.tech.market.project.service.entity.StockDay;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockDayServiceImpl extends ServiceImpl<StockDayMapper, StockDay> implements StockDayService {

    @Override
    public Boolean insertOrUpdateBath(List<StockDay> stockDays) {
        if(StringUtils.isEmpty(stockDays)) {
            return false;
        }
        try {
            return this.saveOrUpdateBatch(stockDays, 100);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
