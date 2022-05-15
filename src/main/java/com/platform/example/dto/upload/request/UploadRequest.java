package com.platform.example.dto.upload.request;

import com.platform.domain.image.ImageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UploadRequest {

    @NotNull
    private ImageType imageType;

}
