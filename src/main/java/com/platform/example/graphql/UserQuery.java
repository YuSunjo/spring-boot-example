package com.platform.example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.platform.domain.user.User;
import com.platform.domain.user.repository.UserRepository;
import com.platform.example.dto.user.UserInfoResponse;
import com.platform.exception.errorCode.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserQuery implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public UserInfoResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 유저입니다."));
        return UserInfoResponse.of(user);
    }

}
