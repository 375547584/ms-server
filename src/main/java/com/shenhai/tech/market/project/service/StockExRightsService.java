package com.shenhai.tech.market.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shenhai.tech.market.project.service.entity.StockExRights;

import java.util.List;

public interface StockExRightsService extends IService<StockExRights> {
    List<StockExRights> getDividendsByCode(String code);

    List<StockExRights> getDividendsByDay(Integer days);

    Integer countStockExRightToday();

}
