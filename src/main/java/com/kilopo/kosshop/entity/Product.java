package com.kilopo.kosshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Product extends BaseEntity {
    private String name;
    private Integer price;
    private String description;
    private Category category;
    private Producer producer;

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    @Column(nullable = false)
    public Integer getPrice() {
        return price;
    }

    @Column
    public String getDescription() {
        return description;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    @ManyToOne
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
