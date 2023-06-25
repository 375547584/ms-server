package com.shenhai.tech.market.project.controller.param;

import lombok.Data;

@Data
public class QueryParam {
    // 版块code
    private String blockCode;
    private String orderField;
    // 1-倒叙 0-不排序 -1-正序
    private Integer order = 0;
}
