package com.example.twworkshopserviceorder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class ApiController {
    final static int SLEEP_INTERVAL = 10000;
    private final static Logger logger = LoggerFactory.getLogger(ApiController.class);
    @Autowired OrderRepository orderRepository;
    @GetMapping("/api/orders")
    public List<VehicleOrder> list(){
        logger.info("order service list is called");
        return orderRepository.findAll();
    }

    static boolean monkeyAwake = false;
    Random r = new Random(SLEEP_INTERVAL);
    @GetMapping("/api/monkey")
    public String monkeySleep(){
        logger.info("monkeySleep?");
        if(monkeyAwake) {
            return "monkey is awake";
        }else {
            int t = r.nextInt(SLEEP_INTERVAL);
            try {
                Thread.sleep(t);
            } catch (Exception ex) {
                ;
            }
            return "monkey sleep " + t / 1000.0;
        }
    }

    @GetMapping("/api/switch-monkey")
    public String switchMonkey(){
        monkeyAwake = !monkeyAwake;
        return "monkey is " + (monkeyAwake ? "awake" : "sleeping");
    }


    class MemoryEater{
        Byte[] data;
        public MemoryEater(){
            data = new Byte[1024*1024];
        }
    }

    List<MemoryEater> memoryEaters = new ArrayList<MemoryEater>();
    @GetMapping("/api/allocate")
    public String allocate(){
        memoryEaters.add(new MemoryEater());
        return calMem();
    }

    @GetMapping("/api/deallocate")
    public String deallocate(){
        memoryEaters.clear();
        return calMem();
    }

    @GetMapping("/api/gc")
    public String leek(){
        Runtime rt = Runtime.getRuntime();
        rt.gc();
        return calMem();
    }

    private String calMem(){
        Runtime rt = Runtime.getRuntime();
        long heapSize = rt.totalMemory()/1024/1024;
        long heapMaxSize = rt.maxMemory()/1024/1024;
        long heapFreeSize = rt.freeMemory()/1024/1024;
        return "heapSize = " + heapSize + ";heapMaxSize = " + heapMaxSize + ";heapFreeSize = " + heapFreeSize;
    }

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
