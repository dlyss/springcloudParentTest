package com.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/add")
    public String order() {
        System.out.printf("order success");
        String responseStr = restTemplate.getForObject("http://stock-service/stock/order",String.class);
        return "order success--"+ responseStr;

    }
}
