package com.platform.example.NfsAndS3;

import com.platform.domain.image.ImageType;
import com.platform.exception.errorCode.ValidationException;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UploadServiceUtils {

    private static final List<String> typeList = Arrays.asList("jpeg", "png", "jpg");

    public static void validateFileType(String originalFilename) {
        String type = FilenameUtils.getExtension(originalFilename);
        if (!typeList.contains(type)) {
            throw new ValidationException(String.format("%s 는 허용되지 않는 파일입니다.", type));
        }
    }

    public static String createFileNameAndDirectory(ImageType imageType, String originalFilename) {
        String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());
        String folder = createFolder(imageType);
        return folder.concat(now.concat(originalFilename));
    }

    private static String createFolder(ImageType imageType) {
        return imageType + "/";
    }

    public static String createFileName(String originalFilename) {
        String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());
        return now.concat(originalFilename);
    }

    public static void validateFolderAndCreate(String nfsPath, ImageType imageType) {
        String directory = nfsPath + imageType;
        Path directoryPath = Paths.get(directory);
        try {
            Files.createDirectories(directoryPath);
        } catch (IOException e) {
            throw new ValidationException("폴더를 생성하지 못했습니다.");
        }
    }

}
