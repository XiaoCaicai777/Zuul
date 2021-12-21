package com.it.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jw
 * @Date 2021/12/21 15:21
 */
//@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String error(){
        return "系统错误";
    }
}
