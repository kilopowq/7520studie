package com.kilopo.kosshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Category extends BaseEntity {
    private String name;

    public Category(){
    }

    public Category(String name){
        this.name = name;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
