package com.shenhai.tech.market.project.controller.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class KLineParam {
    @ApiModelProperty(value = "股票编号", example = "003021")
    private String stockCode;

    @ApiModelProperty(value = "类型 0=分钟 1=日", example = "0")
    private Integer type;

    @ApiModelProperty(value = "当type=1时 period 表示日周期 0=日线 1=周线 2=月线\n " +
            "当type=0时 period 表示分钟周期 0=1分钟; 1=5分钟; 2=15分钟;3=30分钟;4=60分钟")
    private Integer period;

    @ApiModelProperty(value = "返回最近多少天的数据", example = "365")
    private Integer count;
}
