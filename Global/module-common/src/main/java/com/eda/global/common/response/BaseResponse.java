package com.eda.global.common.response;

import com.eda.global.common.error.ErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class BaseResponse<T> {
    private int status;
    private String message;
    private T data;

    public static <T> ResponseEntity<BaseResponse<?>> ok(T data) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.of(SuccessCode.OK, data));
    }

    public static <T> ResponseEntity<BaseResponse<?>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.of(SuccessCode.CREATED, data));
    }

    public static <T> ResponseEntity<BaseResponse<?>> accepted(T data) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(BaseResponse.of(SuccessCode.ACCEPTED, data));
    }

    public static <T> BaseResponse<?> of(SuccessCode successCode, T data) {
        return BaseResponse.builder()
                .status(successCode.getHttpStatus().value())
                .message(successCode.getMessage())
                .data(data)
                .build();
    }

    public static <T> ResponseEntity<BaseResponse<?>> error(ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(BaseResponse.builder()
                        .status(errorCode.getHttpStatus().value())
                        .message(errorCode.getMessage())
                        .build());
    }
}
