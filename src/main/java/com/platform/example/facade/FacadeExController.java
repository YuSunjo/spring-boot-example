package com.platform.example.facade;

import com.platform.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FacadeExController {

    private final FacadeExFacade facadeExFacade;

    @GetMapping("/api/v1/facade")
    public ApiResponse<String> facade() {
        facadeExFacade.facade();
        return ApiResponse.OK;
    }

}
