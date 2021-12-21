package com.it.demo.config;

import com.netflix.hystrix.HystrixInvokableInfo;
import com.netflix.ribbon.hystrix.FallbackHandler;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import rx.Observable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @Author jw
 * @Date 2021/12/21 15:47
 * @Desc: 因为熔断效果是只适用于超时
 */
@Configuration
public class HystrixConfig implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * fallback的状态码
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            /**
             * fallback的状态码
             * @return
             * @throws IOException
             */

            @Override
            public int getRawStatusCode() throws IOException {
                //return status.value();
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }


            /**
             * fallback的状态码 返回String
             * @return
             * @throws IOException
             */
            @Override
            public String getStatusText() throws IOException {
                //return status.getReasonPhrase();
                //return HttpStatus.BAD_REQUEST.name();
                return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 设置方法体
             * Zuul会将本方法返回的输入流数据读取，并且通过HttpServletResponse的输出流输出到客户端
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("{\"message:\",\"服务暂时不可用\"}".getBytes());
            }

            /**
             * 设置响应头
             * @return
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
