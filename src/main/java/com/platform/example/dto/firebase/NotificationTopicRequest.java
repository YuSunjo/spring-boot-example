package com.platform.example.dto.firebase;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NotificationTopicRequest {

    private String title;
    private String message;
    private String topic;

    public NotificationTopicRequest(String title, String message, String topic) {
        this.title = title;
        this.message = message;
        this.topic = topic;
    }

    public static NotificationTopicRequest of(String title, String message, String topic) {
        return new NotificationTopicRequest(title, message, topic);
    }

}
