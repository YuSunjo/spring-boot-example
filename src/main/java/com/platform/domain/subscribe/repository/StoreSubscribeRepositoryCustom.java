package com.platform.domain.subscribe.repository;

import com.platform.domain.subscribe.StoreSubscribe;

import java.util.List;
import java.util.Optional;

public interface StoreSubscribeRepositoryCustom {

    Optional<StoreSubscribe> findByStoreIdAndUserId(Long storeId, Long userId);

    List<Long> findByUserId(Long userId);

    List<StoreSubscribe> findByStoreId(Long storeId, Boolean isAlarm);

}
