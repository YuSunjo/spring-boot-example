package com.platform.domain.user;

import lombok.Getter;

@Getter
public enum UserType {

    USER("USER"), ACCOUNT("ACCOUNT"), ALL("ALL");

    final String type;

    UserType(String type) {
        this.type = type;
    }

}
