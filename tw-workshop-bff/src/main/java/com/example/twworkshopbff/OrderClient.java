package com.example.twworkshopbff;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("order")
public interface OrderClient {
    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    List<Order> list(@RequestParam("shop_id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/monkey")
    String monkey();

}

