package com.platform.example.graphql.board;

import com.platform.domain.board.Board;
import com.platform.domain.board.repository.BoardRepository;
import com.platform.domain.user.User;
import com.platform.domain.user.repository.UserRepository;
import com.platform.example.dto.board.BoardInfoResponse;
import com.platform.example.dto.board.CreateBoardRequest;
import com.platform.exception.errorCode.NotFoundException;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@GraphQLApi
@Transactional
public class GraphQlBoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @GraphQLQuery
    public BoardInfoResponse getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 유저입니다."));
        return BoardInfoResponse.of(board);
    }

    @GraphQLQuery
    public List<BoardInfoResponse> findAllBoard() {
        return boardRepository.findBoardAll().stream().map(BoardInfoResponse::of).collect(Collectors.toList());
//        return boardRepository.findAll().stream().map(BoardInfoResponse::of).collect(Collectors.toList());
    }

    @GraphQLMutation
    public BoardInfoResponse createBoard(CreateBoardRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException("존재하지 않는 유저입니다."));
        Board board = boardRepository.save(request.toEntity(user));
        return BoardInfoResponse.of(board);
    }

}
