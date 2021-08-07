package com.zc.eshop.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zc.eshop.admin.dao")
public class AdminApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class);
    }
}
