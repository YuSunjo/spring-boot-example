package com.platform.exception.errorCode;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ErrorCode {

    INTERNAL_ERROR("500", "서버애러입니다."),
    ENUM_VALIDATION("400", "잘못된 enum 입력입니다."),
    NOT_FOUND_EXCEPTION("404", "존재하지 않습니다."),
    JWT_UNAUTHORIZED_EXCEPTION("403", "인증 에러입니다."),
    CONFLICT_EXCEPTION("409", "이미 존재합니다."),
    VALIDATION_EXCEPTION("400", "잘못된 입력입니다."),
    ASYNC_EXCEPTION("410", "비동기 처리하는데 문제가 생겼습니다.");

    private final String code;
    private final String message;

}
