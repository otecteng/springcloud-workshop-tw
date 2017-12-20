package com.example.twworkshopserviceorder;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class VehicleOrder {
    @Id
    private String id = UUID.randomUUID().toString();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String vehicle;
    public int price;
    public Date createdAt;

    @ManyToOne
    @JoinColumn(referencedColumnName = "code")
    public Shop shop;
}
