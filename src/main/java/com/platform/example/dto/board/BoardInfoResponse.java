package com.platform.example.dto.board;

import com.platform.domain.board.Board;
import com.platform.domain.user.User;
import com.platform.example.dto.user.UserInfoResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardInfoResponse {

    private Long id;
    private String title;
    private String content;

    public BoardInfoResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static BoardInfoResponse of(Board board) {
        return new BoardInfoResponse(board.getId(), board.getTitle(), board.getContent());
    }

}
