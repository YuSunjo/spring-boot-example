package com.platform.example.strategy;

import com.platform.example.dto.user.CreateUserRequest;

public interface UserFactoryService {

    void createUser(CreateUserRequest request);

}
