package com.shenhai.tech.market.project.strategy.entity;

import com.shenhai.tech.market.project.strategy.zlhq.entity.BlockItem;
import lombok.Data;

import java.util.List;

@Data
public class BlockStock {
    /**
     * 证券代码
     */
    private String symbol;
    /**
     * 证券code
     */
    private String code;
    /**
     * 证券代码
     */
    private String name;
    /**
     * 区域
     */
    private List<BlockItem> region;
    /**
     * 行业
     */
    private List<BlockItem> industry;
    /**
     * 概念
     */
    private List<BlockItem> concept;
}
