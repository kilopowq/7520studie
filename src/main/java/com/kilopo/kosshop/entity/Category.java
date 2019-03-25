package com.kilopo.kosshop.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Category extends BaseEntity {
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Column(unique = true)
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
