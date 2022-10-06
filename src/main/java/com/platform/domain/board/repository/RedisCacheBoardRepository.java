package com.platform.domain.board.repository;

import com.platform.domain.board.RedisCacheBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedisCacheBoardRepository extends JpaRepository<RedisCacheBoard, Long> {
}
