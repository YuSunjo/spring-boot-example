package com.platform.example.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacadeExFacade {

    private final FacadeExAService facadeExAService;
    private final FacadeExBService facadeExBService;

    public void facade() {
        facadeExAService.facadeA();
        facadeExBService.facadeB();
    }

}
