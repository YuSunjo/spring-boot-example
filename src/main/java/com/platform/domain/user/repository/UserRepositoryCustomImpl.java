package com.platform.domain.user.repository;

import com.platform.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.platform.domain.board.QBoard.board;
import static com.platform.domain.user.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(
                queryFactory.selectFrom(user)
                        .where(
                                user.id.eq(id)
                        )
                        .fetchOne()
        );
    }

    @Override
    public List<User> findAllUser() {
        return queryFactory.selectFrom(user)
                .leftJoin(user.boardList, board).fetchJoin()
                .fetch();
    }

}
