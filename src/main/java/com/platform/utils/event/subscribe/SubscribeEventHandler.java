package com.platform.utils.event.subscribe;

import com.platform.utils.event.subscribe.request.SubscribeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscribeEventHandler {

    private final SubscribeEventService subscribeEventService;

    @Async
    @EventListener
    public void subscribeToken(SubscribeEvent event) {
        subscribeEventService.subscribeToken(event);
    }

}
