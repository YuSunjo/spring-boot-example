package com.platform.utils.event.subscribe;

import com.platform.utils.event.subscribe.request.SubscribeEvent;
import com.platform.utils.firebase.FCMComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscribeEventService {

    private final FCMComponent fcmComponent;

    public void subscribeToken(SubscribeEvent event) {
        event.getStoreIdList().forEach((storeId) ->
                fcmComponent.subscribeTopic(event.getFcmToken(), storeId)
        );
    }

}
