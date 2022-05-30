package com.platform.example.dto.board;

import com.platform.domain.board.Board;
import com.platform.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBoardRequest {

    private String title;
    private String content;
    private Long userId;

    public Board toEntity(User user) {
        return new Board(title, content, user);
    }

}
