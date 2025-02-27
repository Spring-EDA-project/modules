package com.eda.global.common.error.exception;

import com.eda.global.common.error.BaseErrorCode;
import com.eda.global.common.error.ErrorCode;

public class BadRequestException extends ModuleErrorException{
    public BadRequestException() {
        super(BaseErrorCode.BAD_REQUEST);
    }

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
