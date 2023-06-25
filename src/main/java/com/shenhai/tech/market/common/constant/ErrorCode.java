package com.shenhai.tech.market.common.constant;

public enum ErrorCode {
    //common error
    COOKIE_ERROR(401, "COOKIE_ERROR",200);
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
    private int httpStatusCode;

    ErrorCode(int code, String msg, int httpStatusCode) {
        this.code = code;
        this.msg = msg;
        this.httpStatusCode = httpStatusCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
