package com.kilopo.kosshop.entity;

import com.kilopo.kosshop.constants.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Address extends BaseEntity {
    private String city;
    private String street;
    private String house;
    private Integer apartment;
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column
    @NotEmpty
    @Size(min = 1, max = 90)
    @Pattern(regexp = Constants.RegExp.STREET, message = Constants.ValidationMessage.STREET)
    public String getStreet() {
        return street;
    }

    @Column
    @NotEmpty
    @Size(min = 1, max = 20)
    @Pattern(regexp = Constants.RegExp.HOUSE, message = Constants.ValidationMessage.HOUSE)
    public String getHouse() {
        return house;
    }

    @Column
    public Integer getApartment() {
        return apartment;
    }

    @Column
    @NotEmpty
    @Size(min = 1, max = 20)
    @Pattern(regexp = Constants.RegExp.CITY, message = Constants.ValidationMessage.CITY)
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
