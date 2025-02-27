package com.eda.global.common.error.exception;

import com.eda.global.common.error.BaseErrorCode;
import com.eda.global.common.error.ErrorCode;

public class MethodNotAllowedException extends ModuleErrorException{
    public MethodNotAllowedException() {
        super(BaseErrorCode.METHOD_NOT_ALLOWED);
    }

    public MethodNotAllowedException(ErrorCode errorCode) {
        super(errorCode);
    }

}
