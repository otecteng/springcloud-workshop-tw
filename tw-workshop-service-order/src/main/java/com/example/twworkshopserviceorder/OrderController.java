package com.example.twworkshopserviceorder;


import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ConfigRepository configRepository;

    @GetMapping("/orders")
    @HystrixCommand(fallbackMethod = "listDefaultOrders")
    public List<VehicleOrder> list(@RequestParam String shop_id) throws Exception {
        if (isBreak(shop_id)) {
            throw new Exception("Circuit Breaker");
        }
        return orderRepository.findByShopId(shop_id);
    }

    private boolean isBreak(@RequestParam String shop_id) {
        return shop_id.equalsIgnoreCase("444") ||
                configRepository.findByConfigName("isBreak").configValue.equalsIgnoreCase("yes");
    }

    public List<VehicleOrder> listDefaultOrders(@RequestParam String shop_id) {
        logger.error("The Hystrix is triggered!");
        VehicleOrder vehicleOrder = new VehicleOrder();
        vehicleOrder.shop = shopRepository.findOne("1");
        return Lists.newArrayList(vehicleOrder);
    }
}

