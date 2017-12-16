package com.example.twworkshopbff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @Autowired
    OrderClient orderClient;

    @Autowired
    VehicleClient vehicleClient;

    @GetMapping("/api/v1/shops/{id}")
    public Shop get(@PathVariable String id){
        Shop ret = new Shop();
        ret.id = id;
        ret.name = "taobao";
        ret.orders = orderClient.list(id);
        ret.vehicles = vehicleClient.list(id);
        return ret;
    }
}
