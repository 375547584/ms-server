package com.shenhai.tech.market.common.exception;


public enum BusinessExceptionEnums {
    RESPONSE_DATA_WRONG(20185, "http请求,返回数据错误");


    private final int code;

    private final String message;

    BusinessExceptionEnums(int value, String desc) {
        this.code = value;
        this.message = desc;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
