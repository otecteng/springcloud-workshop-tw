package com.example.twworkshopservicevehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> list(@RequestParam String shop_id){
        return vehicleRepository.findByShopId(shop_id);
    }
}
