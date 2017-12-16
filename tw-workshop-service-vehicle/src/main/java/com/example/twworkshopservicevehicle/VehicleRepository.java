package com.example.twworkshopservicevehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository  extends JpaRepository<Vehicle, String> {
    List<Vehicle> findByShopId(String shop_id);
}
