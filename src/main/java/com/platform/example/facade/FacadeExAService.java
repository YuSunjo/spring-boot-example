package com.platform.example.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacadeExAService {

    private final FacadeExBService facadeExBService;

    public void facadeA() {
        facadeExBService.facadeB();
    }

}
