package com.it.demo.config;

import com.netflix.discovery.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author jw
 * @Date 2021/12/21 11:48
 */
@Configuration
public class ZuulConfig extends ZuulFilter {
    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if (token==null || token.equals("")) {
            currentContext.setSendZuulResponse(false);
            throw new RuntimeException("未经验证的请求");
        }
        return null;
    }
}
