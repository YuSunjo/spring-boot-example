package com.platform.example.feignClient;

import com.platform.ApiResponse;
import com.platform.example.fcm.FcmService;
import com.platform.example.NfsAndS3.UploadService;
import com.platform.utils.feign.TestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeignController {

    private final FcmService fcmService;
    private final UploadService uploadService;

    // feignClient 예제
    @GetMapping("api/v1/system/test/{lecture}/lecture/{lectureId}")
    public ApiResponse<TestResponse> test(@PathVariable String lecture, @PathVariable String lectureId) {
        return ApiResponse.success(fcmService.test(lecture, lectureId));
    }

}
