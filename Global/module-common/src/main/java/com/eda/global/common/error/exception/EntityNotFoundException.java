package com.eda.global.common.error.exception;

import com.eda.global.common.error.BaseErrorCode;
import com.eda.global.common.error.ErrorCode;

public class EntityNotFoundException extends ModuleErrorException{
    public EntityNotFoundException() {
        super(BaseErrorCode.ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
