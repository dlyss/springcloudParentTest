package com.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="stock-service",path = "/stock")
public interface FeignInterface {
    @RequestMapping("/order")
    public String stock();
}
/**
 * public class StockController {
 *     @RequestMapping("/order")
 *     public String stock() {
 *         System.out.printf("stock order success");
 *         return "stock order success";
 *     }
 * }
 */