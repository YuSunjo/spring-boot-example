package com.platform.domain.subscribe.repository;

import com.platform.domain.subscribe.StoreSubscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreSubscribeRepository extends JpaRepository<StoreSubscribe, Long>, StoreSubscribeRepositoryCustom {
}
