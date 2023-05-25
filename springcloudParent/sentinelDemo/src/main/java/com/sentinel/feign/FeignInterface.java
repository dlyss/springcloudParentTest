package com.sentinel.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="stock-service",path = "/stock")
public interface FeignInterface {
    @RequestMapping("/order")
    public String order();
}
