package com.kilopo.kosshop.entity;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private String login;
    private String password;
    private Role role;

    @Column(unique = true)
    @NotNull
    public String getLogin() {
        return login;
    }

    @Column
    @NotNull
    public String getPassword() {
        return password;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    @Column
    @NotNull
    public String getName() {
        return name;
    }

    @Column
    @NotNull
    public String getSername() {
        return sername;
    }

    @Column
    @NotNull
    public String getMiddlename() {
        return middlename;
    }

    @Column
    @NotNull
    public Long getPhone() {
        return phone;
    }

    @Column(unique = true)
    @NotNull
    public String getEmail() {
        return email;
    }

    @Column
    @NotNull
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
