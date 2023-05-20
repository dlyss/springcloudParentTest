package com.springcloud.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeignInterceptorConfig implements RequestInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void apply(RequestTemplate requestTemplate) {
        logger.info("interceptor");
        requestTemplate.header("xxx","xxx");
    }
}
