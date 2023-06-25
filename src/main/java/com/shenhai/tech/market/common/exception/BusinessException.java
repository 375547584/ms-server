package com.shenhai.tech.market.common.exception;


import java.text.MessageFormat;

public class BusinessException extends BaseException {
    private static final long serialVersionUID = 1L;

    public BusinessException(BusinessExceptionEnums businessExceptionEnums) {
        super(businessExceptionEnums.getCode(), businessExceptionEnums.getMessage());
    }

    public BusinessException(BusinessExceptionEnums businessExceptionEnums, Object... obj) {
        super(businessExceptionEnums.getCode(), MessageFormat.format(businessExceptionEnums.getMessage(),obj));
    }

    public BusinessException(Integer code, String message) {
        super(code, message);
    }
}
