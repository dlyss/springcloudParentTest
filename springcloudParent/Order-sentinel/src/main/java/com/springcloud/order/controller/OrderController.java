package com.springcloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("/add")
    public String order() {
        System.out.println("order success");
      //  String responseStr = restTemplate.getForObject("http://localhost:8010/stock/order",String.class);
        return "order success--sentinel--"+System.currentTimeMillis();

    }
    @RequestMapping("/ping")
   // @SentinelResource()
    public String ping() {
        System.out.println("ping success");
        //  String responseStr = restTemplate.getForObject("http://localhost:8010/stock/order",String.class);
        return "order success--sentinel--"+System.currentTimeMillis();

    }
}
