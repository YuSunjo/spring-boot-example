package com.platform.example.feignClient;

import com.platform.utils.feign.TestFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignService {

    private final TestFeignClient testFeignClient;

    public String ping() {
        return testFeignClient.ping();
    }

}
