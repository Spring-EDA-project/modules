package com.eda.global.common.error.exception;

import com.eda.global.common.error.BaseErrorCode;
import com.eda.global.common.error.ErrorCode;

public class UnauthorizedException extends ModuleErrorException{
    public UnauthorizedException() {
        super(BaseErrorCode.UNAUTHORIZED);
    }

    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
