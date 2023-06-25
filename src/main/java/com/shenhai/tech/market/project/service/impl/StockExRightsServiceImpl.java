package com.shenhai.tech.market.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shenhai.tech.market.framework.datasource.IQuery;
import com.shenhai.tech.market.project.service.StockExRightsService;
import com.shenhai.tech.market.project.service.entity.StockExRights;
import com.shenhai.tech.market.project.service.mapper.StockExRightsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class StockExRightsServiceImpl extends ServiceImpl<StockExRightsMapper, StockExRights> implements StockExRightsService {
    @Override
    public List<StockExRights> getDividendsByCode(String code) {
        return this.list(new IQuery<StockExRights>().eq(StockExRights::getStockCode, code).orderByDesc(StockExRights::getDividendDate));
    }

    @Override
    public List<StockExRights> getDividendsByDay(Integer days) {
        if(days == null) {
            days = 30;
        }
        LocalDate startDate = LocalDate.now().minusDays(days);
        LocalDate endDate = LocalDate.now().plusDays(days);
        return this.list(new IQuery<StockExRights>().between(StockExRights::getAnnDate, startDate, endDate));
    }

    @Override
    public Integer countStockExRightToday() {
        LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return this.count(new IQuery<StockExRights>().between(StockExRights::getCreateDate, startTime, endTime));
    }
}
