package com.platform.utils.event.subscribe.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeEvent {

    private List<Long> storeIdList;
    private String fcmToken;

    public static SubscribeEvent of(List<Long> storeIdList, String fcmToken) {
        return new SubscribeEvent(storeIdList, fcmToken);
    }

}
