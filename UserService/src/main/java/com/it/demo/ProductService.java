package com.it.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author jw
 * @Date 2021/12/20 15:00
 */
@SpringBootApplication
@EnableFeignClients
public class ProductService {
    public static void main(String[] args) {
        SpringApplication.run(ProductService.class,args);
    }
}
