package com.platform.config.feignClient;

import com.platform.PlatformApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackageClasses = PlatformApplication.class)
@Configuration
public class FeignClientConfig {
}
