package com.platform.example.dto.alarm.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AlarmRequest {

    @NotNull
    private Long broadcastId;

    @NotNull
    private Long storeId;

}
