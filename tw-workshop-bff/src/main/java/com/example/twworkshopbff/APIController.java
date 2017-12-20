package com.example.twworkshopbff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

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


}
