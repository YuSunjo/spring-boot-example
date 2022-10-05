package com.platform.example.webClient;

import com.platform.exception.errorCode.BusinessException;
import com.platform.exception.errorCode.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class WebClientApiCallerImpl implements WebClientApiCaller {

    private final WebClient webClient;
    private final Duration timeout = Duration.ofMillis(20000);

    @Override
    public String ping() {
        return webClient
                .get()
                .uri("https://api-lovga.site/ping")
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new BusinessException(ErrorCode.API_CALLER)))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new BusinessException(ErrorCode.API_CALLER)))
                .bodyToMono(String.class)
                .timeout(timeout, Mono.error(new BusinessException(ErrorCode.TIMEOUT_EXCEPTION)))
                .block();
    }
}
