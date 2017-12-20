package com.example.twworkshopserviceorder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;
import static javax.persistence.CascadeType.ALL;

@Entity
public class Shop implements Serializable{
    @Id
    private String id = UUID.randomUUID().toString();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String code;
    public String name;

    public String f1;
    public String f2;
    public String f3;
    public String f4;
    public String f5;
    public String f6;
    public String f7;
    public String f8;
    public String f9;
    public String f10;

//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private List<VehicleOrder> orders = newArrayList();

}
