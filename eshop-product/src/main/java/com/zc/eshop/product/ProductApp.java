package com.zc.eshop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.zc.eshop")
@EnableSwagger2
@EnableDiscoveryClient
public class ProductApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class,args);
    }
}
