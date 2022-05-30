package com.platform.example.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.platform.domain.user.User;
import com.platform.domain.user.repository.UserRepository;
import com.platform.example.dto.user.CreateUserRequest;
import com.platform.example.dto.user.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final UserRepository userRepository;

    public UserInfoResponse createUser(CreateUserRequest request) {
        User user = userRepository.save(request.toEntity());
        return UserInfoResponse.of(user);
    }

}
