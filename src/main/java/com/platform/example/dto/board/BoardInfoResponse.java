package com.platform.example.dto.board;

import com.platform.domain.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardInfoResponse {

    private Long id;
    private String title;
    private String content;
    private Long userId;

    public BoardInfoResponse(Long id, String title, String content, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public static BoardInfoResponse of(Board board) {
        return new BoardInfoResponse(board.getId(), board.getTitle(), board.getContent(), board.getUserId());
    }

}
