package com.example.twworkshopserviceorder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConfigRepository extends JpaRepository<SystemConfig, String> {
    SystemConfig findByConfigName(String config_name);
}

