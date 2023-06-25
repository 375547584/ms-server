package com.shenhai.tech.market.project.strategy.zlhq.entity;

import lombok.Data;

import java.util.Map;

/**
 * 板块股票
 */
@Data
public class BlockDataVO {
    /**
     * 区域
     */
    private Map<String, Block> regionMap;
    /**
     * 行业
     */
    private Map<String, Block> industryMap;
    /**
     * 概念
     */
    private Map<String, Block> conceptMap;
}