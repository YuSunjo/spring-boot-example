package com.platform.example.dto.user;

import com.platform.domain.user.User;
import com.platform.example.dto.board.BoardInfoResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class UserInfoResponse {

    private Long id;

    private String name;

    private String age;

    private List<BoardInfoResponse> boardList;

    public UserInfoResponse(Long id, String name, String age, List<BoardInfoResponse> boardList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.boardList = boardList;
    }

    public static UserInfoResponse of(User user) {
        return new UserInfoResponse(user.getId(), user.getName(), user.getAge(), user.getBoardList().stream().map(BoardInfoResponse::of).collect(Collectors.toList()));
    }

}
