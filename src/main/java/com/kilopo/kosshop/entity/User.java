package com.kilopo.kosshop.entity;

import com.kilopo.kosshop.constants.Constants;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String name;
    private String sername;
    private String middlename;
    private Long phone;
    private String email;
    private Date registrationDate;
    private List<Address> address;
    private String login;
    private String password;
    private Role role;
    private boolean approval;

    public User() {
    }

    @Column
    public boolean getApproval() {
        return approval;
    }

    @Column(unique = true)
    @NotEmpty
    @Size(min = 2, max = 20)
    @Pattern(regexp = Constants.RegExp.LOGIN, message = Constants.ValidationMessage.LOGIN)
    public String getLogin() {
        return login;
    }

    @Column
    @NotEmpty
    @Size(min = 6, max = 100)
    @Pattern(regexp = Constants.RegExp.PASSWORD, message = Constants.ValidationMessage.PASSWORD)
    public String getPassword() {
        return password;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    @Column
    @NotEmpty
    @Size(min = 1, max = 60)
    @Pattern(regexp = Constants.RegExp.NAME, message = Constants.ValidationMessage.NAME)
    public String getName() {
        return name;
    }

    @Column
    @NotEmpty
    @Size(min = 1, max = 60)
    @Pattern(regexp = Constants.RegExp.SERNAME, message = Constants.ValidationMessage.SERNAME)
    public String getSername() {
        return sername;
    }

    @Column
    @NotEmpty
    @Size(min = 1, max = 60)
    @Pattern(regexp = Constants.RegExp.MIDDLENAME, message = Constants.ValidationMessage.MIDDLENAME)
    public String getMiddlename() {
        return middlename;
    }

    @Column(unique = true)
    public Long getPhone() {
        return phone;
    }

    @Column(unique = true)
    @NotEmpty
    @Email
    @Size(min = 1, max = 60)
    public String getEmail() {
        return email;
    }

    @Column
    public Date getRegistrationDate() {
        return registrationDate;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    @Valid
    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
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

    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}
