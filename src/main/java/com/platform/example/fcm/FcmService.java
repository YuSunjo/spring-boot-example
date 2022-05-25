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

    private final TestFeignClient testFeignClient;
    private final ApplicationEventPublisher eventPublisher;

    public TestResponse test(String lecture, String lectureId) {
        TestResponse newBOX = testFeignClient.test(lecture, lectureId);
        System.out.println("newBOX = " + newBOX);
        return newBOX;
    }

    @Transactional
    public void alarm(AlarmRequest request) {
        eventPublisher.publishEvent(AlarmEvent.of(1L, request.getBroadcastId(), "token", List.of(1L, 2L)));
    }

}
