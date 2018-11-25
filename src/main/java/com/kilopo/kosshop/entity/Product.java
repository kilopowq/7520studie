package com.kilopo.kosshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.EnumType;

@Entity
public class Product extends BaseEntity {
    private String name;
    private Integer price;
    private String description;
    private Category category;
    private Producer producer;
    private String image;
    private Color color;

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

    @Column
    public String getImage() {
        return image;
    }

    @Enumerated(EnumType.STRING)
    public Color getColor() {
        return color;
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

    public void setImage(String image) {
        this.image = image;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" + "id = " + getId() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", color=" + color +
                ", producer=" + producer +
                ", image='" + image + '\'' +
                '}';
    }
}
