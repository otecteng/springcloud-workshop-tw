package com.example.twworkshopserviceorder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository  extends JpaRepository<Shop, String> {
}