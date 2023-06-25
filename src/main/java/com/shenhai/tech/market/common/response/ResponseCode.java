package com.shenhai.tech.market.common.response;


public enum ResponseCode {
    SUCCESS(1, "success"),
    PARAMS_ERROR(401, "参数错误"),
    NOT_LOGIN(501, "未登陆,请重新登录"),
    INTERNAL_ERROR(502, "系统内部错误"),

    REQUEST_Exter_Inface_ERR(4001, "请求外部接口出错"),
    SYMBOL_CODE_ERR(4002, "股票代码不能为空"),
    INTERFACE_TIME_OUT(4003, "接口请求超时"),
    INTERFACE_TIME_ERROR(4004, "接口请求出错"),
    SUBSCRIBE_EVENT_NOT_FOUND(4005, "该订阅事件不存在");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    }