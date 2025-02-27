package com.eda.global.common.error.exception;

import com.eda.global.common.error.BaseErrorCode;
import com.eda.global.common.error.ErrorCode;

public class ConflictException extends ModuleErrorException{
    public ConflictException() {
        super(BaseErrorCode.CONFLICT);
    }

    public ConflictException(ErrorCode errorCode) {
        super(errorCode);
    }
}
