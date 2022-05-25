package com.platform.example.strategy;

import com.platform.example.dto.user.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements UserFactoryService {

    @Override
    public void createUser(CreateUserRequest request) {
        // account 로직 수행
    }

}
