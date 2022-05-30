package com.platform.example.dto.user;

import com.platform.domain.user.User;
import com.platform.domain.user.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequest {

    private String name;
    private String age;

    private UserType userType;

    public User toEntity() {
        return new User(name, age);
    }

}
