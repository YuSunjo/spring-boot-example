package com.platform.example.strategy;

import com.platform.example.dto.user.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFactory userFactory;

    @PostMapping("api/v1/user")
    public void createUser(@RequestBody @Valid CreateUserRequest request) {
        UserFactoryService userService = userFactory.getUserService(request.getUserType());
        userService.createUser(request);
    }

}
