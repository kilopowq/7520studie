package com.kilopo.kosshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Producer extends BaseEntity {
    private String name;

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
