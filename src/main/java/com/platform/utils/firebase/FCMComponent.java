package com.platform.utils.firebase;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import com.platform.exception.errorCode.ConflictException;
import com.platform.example.dto.firebase.NotificationTokenRequest;
import com.platform.example.dto.firebase.NotificationTopicRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FCMComponent {

    public void tokenSend(NotificationTokenRequest notificationTokenRequest) {
        try {
            Message message = Message.builder()
                    .setToken(notificationTokenRequest.getToken())
                    .setWebpushConfig(WebpushConfig.builder().putHeader("ttl", "300")
                            .setNotification(new WebpushNotification(notificationTokenRequest.getTitle(),
                                    notificationTokenRequest.getMessage()))
                            .build())
                    .build();

            String response = FirebaseMessaging.getInstance().sendAsync(message).get();
            log.info("Sent message: " + response);
        } catch (Exception e) {
            throw new ConflictException("sdfsf");
        }
    }

    public void topicSend(NotificationTopicRequest notificationTokenRequest) {
        try {
            Message message = Message.builder()
                    .setTopic(notificationTokenRequest.getTopic())
                    .setWebpushConfig(WebpushConfig.builder().putHeader("ttl", "300")
                            .setNotification(new WebpushNotification(notificationTokenRequest.getTitle(),
                                    notificationTokenRequest.getMessage()))
                            .build())
                    .build();

            String response = FirebaseMessaging.getInstance().sendAsync(message).get();
            log.info("Sent message: " + response);
        } catch (Exception e) {
            throw new ConflictException("sdfsf");
        }
    }

    public void subscribeTopic(String token, Long storeId) {
        List<String> tokenList = List.of(token);
        try {
            FirebaseMessaging.getInstance().subscribeToTopic(tokenList, storeId.toString());
        } catch (Exception e) {
            throw new ConflictException();
        }
    }

    public void subscribeTopic(List<String> tokenList, Long storeId) {
        try {
            FirebaseMessaging.getInstance().subscribeToTopic(tokenList, storeId.toString());
        } catch (Exception e) {
            throw new ConflictException();
        }
    }

    public void unSubscribeTopic(List<String> tokenList, Long storeId) {
        try {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(tokenList, storeId.toString());
        } catch (Exception e) {
            throw new ConflictException();
        }
    }

}
