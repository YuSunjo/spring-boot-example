package com.platform.example.redis;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final String topic = "test";

    public void publish(Object message) {
        Gson gson = new Gson();
        redisTemplate.convertAndSend(topic, gson.toJson(message));
    }

}
