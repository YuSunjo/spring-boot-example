package com.platform.config.webClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

    ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder() .codecs(
            configurer -> configurer.defaultCodecs().maxInMemorySize(20 * 1024 * 1024)
    ).build();

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create()
                                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 20000)
                                .doOnConnected(conn ->
                                        conn.addHandler(new ReadTimeoutHandler(20000, TimeUnit.MILLISECONDS))
                                )

                )).build();
    }

}
