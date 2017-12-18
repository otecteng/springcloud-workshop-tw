package com.example.twworkshopserviceorder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);
    @Autowired
    ConfigRepository configRepository;

    @GetMapping("/system/config")
    public SystemConfig list(@RequestParam String config_value, @RequestParam String config_name) throws Exception {
        SystemConfig byConfigName = configRepository.findByConfigName(config_name);
        byConfigName.configValue = config_value;
        configRepository.save(byConfigName);
        return byConfigName;
    }
}

