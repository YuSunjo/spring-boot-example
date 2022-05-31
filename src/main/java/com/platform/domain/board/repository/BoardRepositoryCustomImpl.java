package com.platform.domain.board.repository;

import com.platform.domain.board.Board;
import com.platform.domain.board.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.platform.domain.board.QBoard.board;

@RequiredArgsConstructor
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Board> findBoardAll() {
        return queryFactory.selectFrom(board)
                .fetch();
    }

}
