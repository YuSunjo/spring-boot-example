package com.platform.domain.user.repository;

import com.platform.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {

    Optional<User> findUserById(Long id);

    List<User> findAllUser();

}
