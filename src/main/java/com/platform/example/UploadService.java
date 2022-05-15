package com.platform.example;

import com.platform.domain.image.ImageType;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String imageUpload(ImageType imageType, MultipartFile file);

    String imageUploadS3(MultipartFile file);

}
