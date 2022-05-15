package com.platform.example.dto.firebase;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NotificationTokenRequest {

    private String title;
    private String message;
    private String token;

    public NotificationTokenRequest(String title, String message, String token) {
        this.title = title;
        this.message = message;
        this.token = token;
    }

    public static NotificationTokenRequest of(String title, String message, String token) {
        return new NotificationTokenRequest(title, message, token);
    }

}
