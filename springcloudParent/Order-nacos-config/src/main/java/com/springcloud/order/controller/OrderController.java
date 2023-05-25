package com.springcloud.order.controller;

import com.springcloud.feign.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
@RequestMapping("/order")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${name}")
    String configValue;
    @Autowired
    FeignInterface feignInterface;
    @RequestMapping("/add")
    public String order() {
        System.out.printf("order success");
       // String responseStr = restTemplate.getForObject("http://stock-service/stock/order",String.class);
        String responseStr = feignInterface.stock();
        return "order success--"+configValue+"=="+ responseStr;

    }
}
