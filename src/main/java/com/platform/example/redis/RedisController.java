package com.platform.example.redis;

import com.platform.ApiResponse;
import com.platform.domain.board.RedisCacheBoard;
import com.platform.example.dto.redis.RedisCacheBoardRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/api/v1/redis")
    public void redis(@RequestBody String message) {
        redisService.publish(message);
    }

    @PostMapping("/api/v1/redis/cache")
    public ApiResponse<String> redisCache(@RequestBody RedisCacheBoardRequest request) {
        redisService.saveRedisCacheBoard(request);
        return ApiResponse.OK;
    }

    @GetMapping("/api/v1/redis/cache")
    public List<RedisCacheBoard> redisCache() {
        return redisService.retrieveBoardByRedisCache();
    }

    @GetMapping("/api/v1/redis/cache/{boardId}")
    public RedisCacheBoard redisCache( @PathVariable Long boardId) {
        return redisService.getBoardByRedisCache(boardId);
    }

    @PutMapping("/api/v1/redis/cache/{boardId}")
    public RedisCacheBoard redisCache(@PathVariable Long boardId, @RequestBody RedisCacheBoardRequest request) {
        return redisService.updateRedisCacheBoard(boardId, request);
    }

    @DeleteMapping("/api/v1/redis/cache/{boardId}")
    public ApiResponse<String> deleteredisCache(@PathVariable Long boardId) {
        redisService.deleteRedisCacheBoard(boardId);
        return ApiResponse.OK;
    }

}
