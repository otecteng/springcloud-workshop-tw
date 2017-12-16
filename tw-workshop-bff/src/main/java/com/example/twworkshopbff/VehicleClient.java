package com.example.twworkshopbff;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("vehicle")
public interface VehicleClient {
    @RequestMapping(method = RequestMethod.GET, value = "/vehicles")
    List<Vehicle> list(@RequestParam("shop_id") String id);
}

