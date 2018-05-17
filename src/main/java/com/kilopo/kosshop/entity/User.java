package com.kilopo.kosshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String name;
    private String sername;
    private String middlename;
    private Long phone;
    private String email;
    private Date registrationDate;
    private Address address;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    @Column(nullable = false)
    public String getSername() {
        return sername;
    }

    @Column(nullable = false)
    public String getMiddlename() {
        return middlename;
    }

    @Column(nullable = false)
    public Long getPhone() {
        return phone;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    @Column(nullable = false)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    @ManyToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
