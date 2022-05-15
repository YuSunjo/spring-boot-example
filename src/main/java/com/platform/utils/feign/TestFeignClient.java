package com.platform.utils.feign;

import com.platform.config.feignClient.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "testFeignClient",
        url = "${test.base_url}",
        configuration = FeignClientConfig.class)
public interface TestFeignClient {

    @GetMapping(value = "{url}/lecture/{lectureId}", produces = "application/json")
    TestResponse test(@PathVariable String url, @PathVariable String lectureId);

}
