package com.platform.domain.subscribe.repository;

import com.platform.domain.subscribe.StoreSubscribe;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.platform.domain.subscribe.QStoreSubscribe.*;

@RequiredArgsConstructor
public class StoreSubscribeRepositoryCustomImpl implements StoreSubscribeRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<StoreSubscribe> findByStoreIdAndUserId(Long storeId, Long userId) {
        return Optional.ofNullable(
                queryFactory.selectFrom(storeSubscribe)
                        .where(
                                storeSubscribe.storeId.eq(storeId),
                                storeSubscribe.userId.eq(userId)
                        )
                        .fetchFirst()
        );
    }

    @Override
    public List<Long> findByUserId(Long userId) {
        return queryFactory.select(storeSubscribe.storeId)
                .from(storeSubscribe)
                .where(
                        storeSubscribe.userId.eq(userId)
                )
                .fetch();
    }

    @Override
    public List<StoreSubscribe> findByStoreId(Long storeId, Boolean isAlarm) {
        return queryFactory.selectFrom(storeSubscribe)
                .where(
                        storeSubscribe.storeId.eq(storeId),
                        eqIsAlarm(isAlarm)
                )
                .fetch();
    }

    private BooleanExpression eqIsAlarm(Boolean isAlarm) {
        return isAlarm != null ? storeSubscribe.isAlarm.eq(isAlarm) : null;
    }

}
