package com.platform.example.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/api/v1/redis")
    public void redis(@RequestBody String message) {
        redisService.publish(message);
    }

}
