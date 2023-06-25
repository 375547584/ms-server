package com.shenhai.tech.market;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
@MapperScan("com.shenhai.tech.market.project.service.mapper")
public class MSServerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(MSServerApplication.class);
    }
}
