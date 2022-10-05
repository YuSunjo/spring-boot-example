package com.platform.example.feignClient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeignController {

    private final FeignService feignService;

    @GetMapping("/feign/ping")
    public String pong() {
        return feignService.ping();
    }

}
