package com.shenhai.tech.market.project.service.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.shenhai.tech.market.project.strategy.entity.Stock;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StockDay extends Stock {
    @TableId
    private String id;//
    private LocalDate dayDate;//更新时间
    private LocalDateTime updateDate;//更新时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDayDate() {
        return dayDate;
    }

    public void setDayDate(LocalDate dayDate) {
        this.dayDate = dayDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
