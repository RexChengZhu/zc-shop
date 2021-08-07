package com.zc.eshop.wares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class WaresApp {

    public static void main(String[] args) {
        SpringApplication.run(WaresApp.class,args);
    }
}
