package com.example.twworkshopservicevehicle;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Vehicle {
    @Id
    private String id = UUID.randomUUID().toString();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    private int price;
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }



    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    private Date created_at;
    public String shopId;

}
