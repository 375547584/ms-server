package com.shenhai.tech.market.project.strategy.entity;

public enum BlockType {
    region(0, "cnarea", "region"),
    industry(1, "sw", "industry"),
    concept(2, "xti", "concept");

    public final int type;
    public final String code;
    public final String description;

    BlockType(int type, String code, String description) {
        this.type = type;
        this.code = code;
        this.description = description;
    }

    public static BlockType getValue(int type) {
        BlockType[] productEnums = values();
        for (BlockType productEnum : productEnums) {
            if ((productEnum.type == type)) {
                return productEnum;
            }
        }
        return null;
    }
}
