package com.eda.global.common.error.exception;

import com.eda.global.common.error.BaseErrorCode;
import com.eda.global.common.error.ErrorCode;

public class InvalidInputValueException extends ModuleErrorException{
    public InvalidInputValueException() {
        super(BaseErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidInputValueException(ErrorCode errorCode) {
        super(errorCode);
    }

}
