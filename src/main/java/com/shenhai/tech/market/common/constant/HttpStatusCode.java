package com.shenhai.tech.market.common.constant;

public enum HttpStatusCode {
    CODE_200(200);

    Integer code;

    HttpStatusCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
