package com.platform.example.graphql.user;

import com.platform.domain.user.User;
import com.platform.domain.user.repository.UserRepository;
import com.platform.example.dto.user.CreateUserRequest;
import com.platform.example.dto.user.UserInfoResponse;
import com.platform.exception.errorCode.NotFoundException;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@GraphQLApi
@Transactional
public class GraphQLUserService {

    private final UserRepository userRepository;

    @GraphQLQuery
    public UserInfoResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 유저입니다."));
        return UserInfoResponse.of(user);
    }

    @GraphQLMutation
    public UserInfoResponse createUser(CreateUserRequest request) {
        User user = userRepository.save(request.toEntity());
        return UserInfoResponse.of(user);
    }

}
