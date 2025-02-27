package com.eda.global.common.error;

import com.eda.global.common.error.exception.BadRequestException;
import com.eda.global.common.error.exception.ConflictException;
import com.eda.global.common.error.exception.EntityNotFoundException;
import com.eda.global.common.error.exception.ForbiddenException;
import com.eda.global.common.error.exception.InternalServerErrorException;
import com.eda.global.common.error.exception.InvalidInputValueException;
import com.eda.global.common.error.exception.MethodNotAllowedException;
import com.eda.global.common.error.exception.ModuleErrorException;
import com.eda.global.common.error.exception.UnauthorizedException;
import com.eda.global.common.response.BaseResponse;
import jakarta.el.MethodNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse<?>> handleBadRequestException(BadRequestException e) {
        return BaseResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<BaseResponse<?>> handleConflictException(ConflictException e) {
        return BaseResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BaseResponse<?>> handleEntityNotFoundException(EntityNotFoundException e) {
        return BaseResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<BaseResponse<?>> handleForbiddenException(ForbiddenException e) {
        return BaseResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<BaseResponse<?>> handleInternalServerErrorException(InternalServerErrorException e) {
        return BaseResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(InvalidInputValueException.class)
    public ResponseEntity<BaseResponse<?>> handleInvalidInputValueException(InvalidInputValueException e) {
        return BaseResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<BaseResponse<?>> handleMethodNotAllowedException(MethodNotAllowedException e) {
        return BaseResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(ModuleErrorException.class)
    public ResponseEntity<BaseResponse<?>> handleModuleErrorException(ModuleErrorException e) {
        return BaseResponse.error(e.getErrorCode());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<BaseResponse<?>> handleUnauthorizedException(UnauthorizedException e) {
        return BaseResponse.error(e.getErrorCode());
    }

}
