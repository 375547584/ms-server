package com.shenhai.tech.market.project.service.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.shenhai.tech.market.common.utils.LocalDateUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StockExRights {

    @TableId
    private String id;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;
    /**
     * 股票名称
     */
    private String stockName;

    /**
     * 股票代码
     */
    private String stockCode;

    /**
     * 10股转增
     */
    private BigDecimal rebate;

    /**
     * 10股送股
     */
    private BigDecimal bonus;

    /**
     * 10股分红
     */
    private BigDecimal dividend;
    /**
     * 公告日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate annDate;

    /**
     * 登记时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerDate;

    /**
     * 除权除息日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dividendDate;

    /**
     * 派息日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("payable_date")
    private LocalDate payableDate;

    /**
     * 备注
     */
    private String remark;

    public String getUniqueId() {
        return String.format("%s_%s", stockCode, LocalDateUtils.format(dividendDate, LocalDateUtils.formatterDD3));
    }
}
