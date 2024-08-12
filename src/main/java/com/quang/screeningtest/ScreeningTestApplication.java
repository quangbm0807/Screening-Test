package com.quang.screeningtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.quang.screeningtest.model")
@EnableJpaRepositories(basePackages = "com.quang.screeningtest.repository")
public class ScreeningTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScreeningTestApplication.class, args);
    }
}

