package com.eda.global.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BaseErrorCode implements ErrorCode{
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "Entity not found"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "Forbidden"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "Invalid input value"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "Method not allowed"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
    CONFLICT(HttpStatus.CONFLICT, "Conflict"),
    MODULE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Module error");         // 모듈별 비즈니스 로직 상 예외처리를 위한 에러

    private final HttpStatus httpStatus;
    private final String message;
}
