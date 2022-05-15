package com.platform.exception.errorCode;

public class ConflictException extends CustomException {

    public ConflictException(String message) {
        super(message, ErrorCode.CONFLICT_EXCEPTION);
    }

    public ConflictException() {
        super(ErrorCode.CONFLICT_EXCEPTION.getMessage(), ErrorCode.CONFLICT_EXCEPTION);
    }

}
