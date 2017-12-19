package com.example.twworkshopserviceorder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class SystemConfig {
    @Id
    private String id = UUID.randomUUID().toString();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String configName;
    public String configValue;
    public Date createdAt;

}
