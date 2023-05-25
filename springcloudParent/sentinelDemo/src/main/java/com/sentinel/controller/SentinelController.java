package com.sentinel.controller;

import com.sentinel.feign.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class SentinelController {
    @Autowired
    public FeignInterface feignInterface;
    @RequestMapping("/add")
    public String order(){
        System.out.println("in client");
        return feignInterface.order();
    }
    @RequestMapping("/ping")
    public String ping(){
        System.out.println("in client");
        return feignInterface.order();
    }
}
