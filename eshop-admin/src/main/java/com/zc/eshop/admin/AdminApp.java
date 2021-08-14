package com.zc.eshop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.zc.eshop.common.feign")
public class AdminApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class);
    }
}
