package com.platform.domain.subscribe;

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
public class StoreSubscribe extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long storeId;

    private boolean isAlarm;

    public StoreSubscribe(Long userId, Long storeId, boolean isAlarm) {
        this.userId = userId;
        this.storeId = storeId;
        this.isAlarm = isAlarm;
    }

    public void updateAlarm(Boolean isAlarm) {
        this.isAlarm = isAlarm;
    }

}
