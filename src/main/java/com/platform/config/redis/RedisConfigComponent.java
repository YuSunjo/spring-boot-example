package com.platform.config.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis")
@Getter
@Setter
public class RedisConfigComponent {

    private String host;
    private Integer port;
    private String password;

}
