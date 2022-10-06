package com.platform.example.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacadeExBService {

    public void facadeB() {
        System.out.println("facade B");
    }

}
