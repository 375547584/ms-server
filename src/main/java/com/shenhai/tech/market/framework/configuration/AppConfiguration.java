package com.shenhai.tech.market.framework.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@ComponentScans({@ComponentScan("com.shenhai.tech.market.*")})
public class AppConfiguration {

    public static final int TIMEOUT = 10000;

    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(TIMEOUT);
        requestFactory.setReadTimeout(TIMEOUT);
        return new RestTemplate(requestFactory);
    }

    @PostConstruct
    void onStart() {
        log.info("AppConfiguration onStart");
    }
}