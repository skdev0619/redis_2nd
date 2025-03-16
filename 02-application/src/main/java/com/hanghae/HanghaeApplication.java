package com.hanghae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hanghae")
public class HanghaeApplication {
    public static void main(String[] args) {
        SpringApplication.run(HanghaeApplication.class, args);
    }
}
