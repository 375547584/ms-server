package com.shenhai.tech.market.common.exception;


public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
