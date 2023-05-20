package com.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="stock-service", path="/stock")
public interface StockFeignService {
    @RequestMapping("/order")
    public String stock() ;
}
/**
 * @RestController
 * @RequestMapping("/order")
 * public class OrderController {
 *     @Autowired
 *     RestTemplate restTemplate;
 *     @RequestMapping("/add")
 *     public String order() {
 *         System.out.printf("order success");
 *         String responseStr = restTemplate.getForObject("http://stock-service/stock/order",String.class);
 *         return "order success--"+ responseStr;
 *
 *     }
 * }
 */