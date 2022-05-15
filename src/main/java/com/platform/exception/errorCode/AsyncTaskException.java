package com.platform.exception.errorCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;

@Slf4j
public class AsyncTaskException extends SimpleAsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(@NotNull Throwable ex, @NotNull Method method, @NotNull Object... params) {
        log.error("[AsyncTaskExceptionHandler] 비동기 처리 중 에러가 발생하였습니다. method {} params: {} exception: {}", method, params, ex);
    }

}
