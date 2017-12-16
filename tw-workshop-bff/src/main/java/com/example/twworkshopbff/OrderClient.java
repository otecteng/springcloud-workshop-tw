package com.example.twworkshopbff;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("order")
public interface OrderClient {
    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    List<Order> list(@RequestParam("shop_id") String id);
}

