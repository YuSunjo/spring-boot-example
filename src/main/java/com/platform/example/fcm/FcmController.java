package com.platform.example.fcm;

import com.platform.ApiResponse;
import com.platform.example.dto.alarm.request.AlarmRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FcmController {

    private final FcmService fcmService;

    // FCM 예제
    @PostMapping("api/v1/alarm/callback")
    public ApiResponse<String> alarm(@RequestBody @Valid AlarmRequest request) {
        fcmService.alarm(request);
        return ApiResponse.OK;
    }

}
