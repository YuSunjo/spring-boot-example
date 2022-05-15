package com.platform.utils.event.alarm.request;

import com.platform.domain.alarm.AlarmLog;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class AlarmEvent {

    private Long storeId;
    private Long broadcastId;
    private String token;
    private List<Long> userIdList;

    public AlarmEvent(Long storeId, Long broadcastId, String token, List<Long> userIdList) {
        this.storeId = storeId;
        this.broadcastId = broadcastId;
        this.token = token;
        this.userIdList = userIdList;
    }

    public static AlarmEvent of(Long storeId, Long broadcastId, String token, List<Long> userIdList) {
        return new AlarmEvent(storeId, broadcastId, token, userIdList);
    }

    public List<AlarmLog> toEntity(String message) {
        return userIdList.stream().map(userId -> AlarmLog.of(userId, storeId, broadcastId, message))
                .collect(Collectors.toList());
    }

}
