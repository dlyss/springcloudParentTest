package com.springcloud.feign.config;

import com.springcloud.feign.interceptor.FeignInterceptorConfig;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 自定义拦截器
     * @return

    @Bean
    public FeignInterceptorConfig feignAuthRequestInterceptor(){
        return new FeignInterceptorConfig();
    }
     */
}
