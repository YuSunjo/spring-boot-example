package com.platform.utils.event.alarm;

import com.platform.utils.event.alarm.request.AlarmEvent;
import com.platform.example.dto.firebase.NotificationTopicRequest;
import com.platform.utils.firebase.FCMComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlarmEventService {

    private final FCMComponent fcmComponent;

    public void alarmFcm(AlarmEvent event) {
        NotificationTopicRequest notificationTopicRequest = NotificationTopicRequest.of(String.format("%s의 방송 입니다.", event.getStoreId()), String.format("%s의 방송이 시작합니다.", event.getBroadcastId()), event.getStoreId().toString());
        fcmComponent.topicSend(notificationTopicRequest);
    }

}
