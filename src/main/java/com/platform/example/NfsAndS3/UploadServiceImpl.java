package com.platform.example.NfsAndS3;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.platform.domain.image.ImageComponent;
import com.platform.domain.image.ImageType;
import com.platform.exception.errorCode.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class UploadServiceImpl implements UploadService {

    private final static String nfsPath = "/webftp/tnswh/image/platform/";
//    private final static String nfsPath = "/Users/tnswh/Documents/sunjo/platform/upload/test/";

    private final ImageComponent imageComponent;
    private final S3Service s3Service;

    @Override
    public String imageUpload(ImageType imageType, MultipartFile file) {
        UploadServiceUtils.validateFileType(file.getOriginalFilename());
        UploadServiceUtils.validateFolderAndCreate(nfsPath, imageType);
        String fileName = UploadServiceUtils.createFileNameAndDirectory(imageType, file.getOriginalFilename());
        String uploadPath = nfsPath.concat(fileName);
        File uploadFile = new File(uploadPath);
        try {
            file.transferTo(uploadFile);
        } catch (IOException e) {
            throw new ValidationException(String.format("%s 이미지 업로드 하는데 오류가 발생했습니다.", file.getOriginalFilename()));
        }
        return String.format("%s%s/%s", imageComponent.getProtocol(), imageComponent.getPath(), fileName);
    }

    public String imageUploadS3(MultipartFile file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());

        try (InputStream inputStream = file.getInputStream()) {
            return s3Service.uploadFile(inputStream, objectMetadata, "fileName");
        } catch (IOException e) {
            throw new ValidationException(String.format("%s 파일을 업로드하는데 오류가 발생했습니다.", file.getOriginalFilename()));
        }
    }

}
