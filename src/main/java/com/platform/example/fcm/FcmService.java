package com.platform.example.fcm;

import com.platform.example.dto.alarm.request.AlarmRequest;
import com.platform.utils.event.alarm.request.AlarmEvent;
import com.platform.utils.feign.TestFeignClient;
import com.platform.utils.feign.TestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FcmService {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void alarm(AlarmRequest request) {
        eventPublisher.publishEvent(AlarmEvent.of(1L, request.getBroadcastId(), "token", List.of(1L, 2L)));
    }

}
