package com.springcloud.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Value("${server.port}")
    String port;
    @RequestMapping("/order")
    public String stock() {
        System.out.printf("stock order success");
        return "stock order success:"+port;
    }
}
