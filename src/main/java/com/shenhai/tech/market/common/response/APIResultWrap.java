package com.shenhai.tech.market.common.response;


import com.shenhai.tech.market.common.constant.ErrorCode;
import com.shenhai.tech.market.common.exception.BusinessException;

public class APIResultWrap {
    public static final Integer SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "操作成功";
    private APIResultWrap() {
    }

    public static <T> APIResult<T> ok(T data, int count) {
        return new APIResult<>(SUCCESS_CODE, SUCCESS_MSG, data, count);
    }

    public static <T> APIResult<T> ok(T data) {
        return new APIResult<>(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> APIResult<T> ok() {
        return new APIResult<>(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> APIResult<T> ok(T data,String message) {
        return new APIResult<>(SUCCESS_CODE, message, data);
    }

    public static APIResult error(BusinessException ex) {
        int errorCode = ex.getCode();
        String errorMessage = ex.getMessage();
        return new APIResult<>(errorCode, errorMessage);
    }

    public static APIResult error(ErrorCode errorCode) {
        return new APIResult<>(errorCode.getCode(), errorCode.getMsg());
    }

    public static APIResult error(int code, String msg) {
        return new APIResult(code, msg);
    }

}
