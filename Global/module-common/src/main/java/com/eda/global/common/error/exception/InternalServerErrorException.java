package com.eda.global.common.error.exception;

import com.eda.global.common.error.BaseErrorCode;
import com.eda.global.common.error.ErrorCode;

public class InternalServerErrorException extends ModuleErrorException{

    public InternalServerErrorException() {
        super(BaseErrorCode.INTERNAL_SERVER_ERROR);
    }

    public InternalServerErrorException(ErrorCode errorCode) {
        super(errorCode);
    }
}
