package com.platform.exception;

import com.platform.ApiResponse;
import com.platform.exception.errorCode.ConflictException;
import com.platform.exception.errorCode.NotFoundException;
import com.platform.exception.errorCode.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionCustomControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    protected ApiResponse<Object> handlerNotFound(NotFoundException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(e.getErrorCode().getCode(), e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    protected ApiResponse<Object> handlerValidation(ValidationException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(e.getErrorCode().getCode(), e.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    protected ApiResponse<Object> handlerValidation(ConflictException e) {
        log.error(e.getMessage(), e);
        return ApiResponse.error(e.getErrorCode().getCode(), e.getMessage());
    }

}
