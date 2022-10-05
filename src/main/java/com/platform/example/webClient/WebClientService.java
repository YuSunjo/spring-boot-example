package com.platform.example.webClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebClientService {

    private final WebClientApiCaller webClientApiCaller;

    public String ping() {
        return webClientApiCaller.ping();
    }

}
