package com.kilopo.kosshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"order_id", "product_id"}))
public class OrderProduct extends BaseEntity {
    private Order order;
    private Product product;
    private Integer amount;

    @ManyToOne
    public Order getOrder() {
        return order;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    @Column(nullable = false)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
