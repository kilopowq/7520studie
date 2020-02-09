package com.kilopo.kosshop.entity;

import javax.validation.constraints.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Base64;

@Entity
public class Product extends BaseEntity {
    private String name;
    private BigDecimal price;
    private String description;
    private Category category;
    private Producer producer;
    private byte[] imageBytes;
    private Color color;
    private String base64Image;

    @Column
    @NotNull
    public String getName() {
        return name;
    }

    @Column
    @NotNull
    public BigDecimal getPrice() {
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
    public byte[] getImageBytes() {
        return imageBytes;
    }

    @Enumerated(EnumType.STRING)
    public Color getColor() {
        return color;
    }

    @Transient
    public String getBase64Image() {
        return Base64.getEncoder().encodeToString(this.imageBytes);
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
