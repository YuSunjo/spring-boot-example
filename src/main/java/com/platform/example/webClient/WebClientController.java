package com.platform.example.webClient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebClientController {

    private final WebClientService webClientService;

    @GetMapping("/webclient/ping")
    public String ping() {
        return webClientService.ping();
    }

}
