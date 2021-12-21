package com.it.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author jw
 * @Date 2021/12/20 14:40
 */
@SpringBootApplication
@EnableZuulProxy
@EnableHystrix
public class QuickStart {
    public static void main(String[] args) {
        SpringApplication.run(QuickStart.class,args);
    }
}
