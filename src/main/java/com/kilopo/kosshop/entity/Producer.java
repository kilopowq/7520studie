package com.kilopo.kosshop.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Producer extends BaseEntity {
    private String name;

    public Producer() {
    }

    public Producer(String name) {
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
