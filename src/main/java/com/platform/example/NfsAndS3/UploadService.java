package com.platform.example.NfsAndS3;

import com.platform.domain.image.ImageType;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String imageUpload(ImageType imageType, MultipartFile file);

    String imageUploadS3(MultipartFile file);

}
