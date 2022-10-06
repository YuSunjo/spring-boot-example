package com.platform.config.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {

    private final RedisConfigComponent redisConfigComponent;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisConfigComponent.getHost());
        redisStandaloneConfiguration.setPort(redisConfigComponent.getPort());
        redisStandaloneConfiguration.setPassword(redisConfigComponent.getPassword());
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        //해쉬 키와 벨류를 찾기 위한 설정
        redisTemplate.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        redisTemplate.setHashValueSerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        return redisTemplate;
    }

}
