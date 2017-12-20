package com.example.twworkshopbff;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class APIController {

    private final static Logger logger = LoggerFactory.getLogger(APIController.class);

    @Autowired
    OrderClient orderClient;

    @Autowired
    VehicleClient vehicleClient;

    @GetMapping("/api/v1/shops/{id}")
    public Shop get(@PathVariable String id, @RequestHeader HttpHeaders headers) {
        logger.info("header: {}" , headers.get("zuul-token"));
        Shop ret = new Shop();
        ret.id = id;
        ret.name = "taobao";
        ret.orders = orderClient.list(id);
        ret.vehicles = vehicleClient.list(id);
        return ret;
    }

    @GetMapping("/api/v1/monkey")
    @HystrixCommand(fallbackMethod = "chicken")
    public String monkey(){
        return orderClient.monkey();
    }

    private String chicken() {
        return "monkey is sleeping , I am chicken";
    }
}
