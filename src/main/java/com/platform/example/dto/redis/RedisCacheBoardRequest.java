package com.platform.example.dto.redis;

import com.platform.domain.board.RedisCacheBoard;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RedisCacheBoardRequest {

    private String title;
    private String content;

    public RedisCacheBoard toEntity() {
        return new RedisCacheBoard(title, content);
    }

}
