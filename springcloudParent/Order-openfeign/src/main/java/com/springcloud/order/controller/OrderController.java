package com.springcloud.order.controller;

import com.springcloud.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    StockFeignService stockFeignService;
    @RequestMapping("/add")
    public String order() {
        //System.out.printf("order success");
        String responseStr = stockFeignService.stock();// restTemplate.getForObject("http://stock-service/stock/order",String.class);
        return "openFeigh order success--"+ responseStr;

    }
}
