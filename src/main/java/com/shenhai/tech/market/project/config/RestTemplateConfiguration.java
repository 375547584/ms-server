package com.shenhai.tech.market.project.config;


import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class RestTemplateConfiguration {
    @Value("${okhttp.connect_timeout}")
    protected Integer connectTimeout;
    @Value("${okhttp.read_timeout}")
    protected Integer readTimeout;
    @Value("${okhttp.write_timeout}")
    protected Integer writeTimeout;
    @Value("${okhttp.max_idle_connections}")
    protected Integer maxIdleConnections;
    @Value("${okhttp.keep_alive_duration}")
    protected Integer keepAliveDuration;

    @Bean
    public RestTemplate restTemplate() {
        ClientHttpRequestFactory factory = httpRequestFactory();
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        return new OkHttp3ClientHttpRequestFactory(okHttpClient());
    }

    @Bean
    public OkHttpClient okHttpClient() {
        ConnectionPool pool = new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.SECONDS);
        return new OkHttpClient().newBuilder()
                .connectionPool(pool)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .hostnameVerifier((hostname, session) -> true)
                .build();
    }
}
