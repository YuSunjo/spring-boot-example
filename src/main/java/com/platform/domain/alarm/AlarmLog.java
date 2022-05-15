package com.platform.domain.alarm;

import com.platform.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AlarmLog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long storeId;

    private Long nalbangBroadcastId;

    private String content;

    public AlarmLog(Long userId, Long storeId, Long nalbangBroadcastId, String content) {
        this.userId = userId;
        this.storeId = storeId;
        this.nalbangBroadcastId = nalbangBroadcastId;
        this.content = content;
    }

    public static AlarmLog of(Long userId, Long storeId, Long nalbangBroadcastId, String content) {
        return new AlarmLog(userId, storeId, nalbangBroadcastId, content);
    }

}
