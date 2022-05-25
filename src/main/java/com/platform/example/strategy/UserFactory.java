package com.platform.example.strategy;

import com.platform.domain.user.UserType;
import com.platform.exception.errorCode.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UserFactory {

    private final UserService userService;
    private final AccountService accountService;
    private final Map<UserType, UserFactoryService> userServiceMap = new EnumMap<>(UserType.class);

    @PostConstruct
    void userServiceMap() {
        userServiceMap.put(UserType.USER, userService);
        userServiceMap.put(UserType.ACCOUNT, accountService);
    }

    public UserFactoryService getUserService(UserType userType) {
        UserFactoryService userFactoryService = userServiceMap.get(userType);
        if (userFactoryService == null) {
            throw new NotFoundException(String.format("존재하지 않는 %s 입니다.", userType));
        }
        return userFactoryService;
    }

//    public UserFactoryService getUserServiceSwitch(UserType userType) {
//        switch (userType) {
//            case USER:
//                return userService;
//            case ACCOUNT:
//                return accountService;
//        }
//        return userService;
//    }

}
