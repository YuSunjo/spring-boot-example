package com.platform.utils.event.alarm;

import com.platform.utils.event.alarm.request.AlarmEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlarmEventHandler {

    private final AlarmEventService alarmEventService;

    @Async
    @EventListener
    public void addNotification(AlarmEvent event) {
        alarmEventService.alarmFcm(event);
    }

}
