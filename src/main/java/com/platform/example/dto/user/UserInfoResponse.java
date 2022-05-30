package com.platform.example.dto.user;

import com.platform.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoResponse {

    private Long id;

    private String name;

    private String age;

    public UserInfoResponse(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static UserInfoResponse of(User user) {
        return new UserInfoResponse(user.getId(), user.getName(), user.getAge());
    }

}
