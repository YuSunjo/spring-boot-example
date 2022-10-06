package com.platform.example.redis;

import com.google.gson.Gson;
import com.platform.domain.board.RedisCacheBoard;
import com.platform.domain.board.repository.RedisCacheBoardRepository;
import com.platform.example.dto.redis.RedisCacheBoardRequest;
import com.platform.exception.errorCode.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisCacheBoardRepository redisCacheBoardRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    private final String topic = "test";

    public void publish(Object message) {
        Gson gson = new Gson();
        redisTemplate.convertAndSend(topic, gson.toJson(message));
    }

    @Transactional
    public void saveRedisCacheBoard(RedisCacheBoardRequest request) {
        redisCacheBoardRepository.save(request.toEntity());
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "Board", key = "'boardList'", cacheManager = "redisCacheManager")
    public List<RedisCacheBoard> retrieveBoardByRedisCache() {
        return redisCacheBoardRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "Board", key = "#boardId", cacheManager = "redisCacheManager")
    public RedisCacheBoard getBoardByRedisCache(Long boardId) {
        return redisCacheBoardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundException(String.format("해당 게시글이 없습니다. id=%s", boardId)));
    }

    @Transactional
    @CachePut(value = "Board", key = "#boardId", cacheManager = "redisCacheManager")
    public RedisCacheBoard updateRedisCacheBoard(Long boardId, RedisCacheBoardRequest request) {
        RedisCacheBoard redisCacheBoard = redisCacheBoardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundException(String.format("해당 게시글이 없습니다. id=%s", boardId)));
        redisCacheBoard.update(request.getTitle(), request.getContent());
        return redisCacheBoard;
    }

    @Transactional
//    @CacheEvict(value = "Board", key = "{#boardId, 'boardList'}", cacheManager = "redisCacheManager")
    @CacheEvict(value = "Board", key = "{'boardList', #boardId}", cacheManager = "redisCacheManager")
    public void deleteRedisCacheBoard(Long boardId) {
        redisCacheBoardRepository.deleteById(boardId);
    }

}
