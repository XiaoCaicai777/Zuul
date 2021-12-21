package com.it.demo.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author jw
 * @Date 2021/12/21 14:12
 */
@Configuration
@Slf4j
public class ErrorConfig extends ZuulFilter {

    @Override
    public String filterType() {
        //异常过滤器
        return "error";
    }

    @Override
    public int filterOrder() {
        //优先级，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true代表需要过滤
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        log.info("进入异常过滤器");

        System.out.println(ctx.getResponseBody());
        ctx.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        ctx.remove("throwable");
        ctx.setResponseBody("出现异常");

        return null;

    }
}
