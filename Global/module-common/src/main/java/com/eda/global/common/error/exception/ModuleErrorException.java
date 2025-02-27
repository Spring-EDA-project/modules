package com.eda.global.common.error.exception;

import com.eda.global.common.error.ErrorCode;
import lombok.Getter;

@Getter
public class ModuleErrorException extends RuntimeException {
    private final ErrorCode errorCode;

    public ModuleErrorException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
