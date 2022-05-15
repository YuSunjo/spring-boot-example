package com.platform.example;

import com.platform.ApiResponse;
import com.platform.example.dto.alarm.request.AlarmRequest;
import com.platform.example.dto.upload.request.UploadRequest;
import com.platform.utils.feign.TestResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;
    private final UploadService uploadService;

    // FCM 예제
    @PostMapping("api/v1/alarm/callback")
    public ApiResponse<String> alarm(@RequestBody @Valid AlarmRequest request) {
        exampleService.alarm(request);
        return ApiResponse.OK;
    }

    // feignClient 예제
    @GetMapping("api/v1/system/test/{lecture}/lecture/{lectureId}")
    public ApiResponse<TestResponse> test(@PathVariable String lecture, @PathVariable String lectureId) {
        return ApiResponse.success(exampleService.test(lecture, lectureId));
    }

    // nfs 를 통해서 이미지 업로드 에제
    @PostMapping("api/v1/image/upload")
    public ApiResponse<String> imageUpload(@Valid UploadRequest request, @RequestPart MultipartFile file) {
        String imageUrl = uploadService.imageUpload(request.getImageType(), file);
        return ApiResponse.success(imageUrl);
    }

    @ApiOperation(value = "이미지 업로드", notes = "일기, 멤버 이미지 파일 업로드")
    @PostMapping("/record-file/{uploadFolder}")
    public ApiResponse<String> recordImageUpload(@RequestPart MultipartFile file) {
        return ApiResponse.success(uploadService.imageUploadS3(file));
    }

}
