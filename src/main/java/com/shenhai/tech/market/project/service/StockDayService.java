package com.shenhai.tech.market.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shenhai.tech.market.project.service.entity.StockDay;

import java.util.List;

public interface StockDayService extends IService<StockDay> {
    Boolean insertOrUpdateBath(List<StockDay> stockDays);
}
