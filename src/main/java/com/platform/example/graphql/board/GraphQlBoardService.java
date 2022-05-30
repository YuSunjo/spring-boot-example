package com.platform.example.graphql.board;

import com.platform.domain.board.Board;
import com.platform.domain.board.repository.BoardRepository;
import com.platform.example.dto.board.BoardInfoResponse;
import com.platform.example.dto.board.CreateBoardRequest;
import com.platform.exception.errorCode.NotFoundException;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@GraphQLApi
public class GraphQlBoardService {

    private final BoardRepository boardRepository;

    @GraphQLQuery
    public BoardInfoResponse getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 유저입니다."));
        return BoardInfoResponse.of(board);
    }

    @GraphQLMutation
    public BoardInfoResponse createBoard(CreateBoardRequest request) {
        Board board = boardRepository.save(request.toEntity());
        return BoardInfoResponse.of(board);
    }

}
