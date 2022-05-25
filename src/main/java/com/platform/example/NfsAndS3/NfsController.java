package com.platform.example.NfsAndS3;

import com.platform.ApiResponse;
import com.platform.example.NfsAndS3.UploadService;
import com.platform.example.dto.upload.request.UploadRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class NfsController {

    private final UploadService uploadService;

    // nfs 를 통해서 이미지 업로드 에제
    @PostMapping("api/v1/image/upload")
    public ApiResponse<String> imageUpload(@Valid UploadRequest request, @RequestPart MultipartFile file) {
        String imageUrl = uploadService.imageUpload(request.getImageType(), file);
        return ApiResponse.success(imageUrl);
    }

}
