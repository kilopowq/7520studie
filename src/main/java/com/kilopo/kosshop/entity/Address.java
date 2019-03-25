package com.kilopo.kosshop.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Address extends BaseEntity {
    private String city;
    private String street;
    private String house;
    private Integer apartment;

    @Column
    @NotNull
    public String getStreet() {
        return street;
    }

    @Column
    @NotNull
    public String getHouse() {
        return house;
    }

    @Column
    public Integer getApartment() {
        return apartment;
    }

    @Column
    @NotNull
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
