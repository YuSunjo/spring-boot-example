package com.platform.example.NfsAndS3;

import com.platform.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class S3Controller {

    private final UploadService uploadService;

    @ApiOperation(value = "이미지 업로드", notes = "일기, 멤버 이미지 파일 업로드")
    @PostMapping("/record-file/{uploadFolder}")
    public ApiResponse<String> recordImageUpload(@RequestPart MultipartFile file) {
        return ApiResponse.success(uploadService.imageUploadS3(file));
    }

}
