package com.platform.exception.errorCode;

public class NotFoundException extends CustomException {

    public NotFoundException(String message) {
        super(message, ErrorCode.NOT_FOUND_EXCEPTION);
    }

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND_EXCEPTION.getMessage(), ErrorCode.NOT_FOUND_EXCEPTION);
    }

}
