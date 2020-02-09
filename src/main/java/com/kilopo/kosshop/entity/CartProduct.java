package com.kilopo.kosshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cart_id", "product_id"}))
public class CartProduct extends BaseEntity {
    private Cart cart;
    private Product product;
    private Integer amount;
    private BigDecimal sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    @Column
    @NotNull
    public Integer getAmount() {
        return amount;
    }

    @Transient
    public BigDecimal getSum() {
        return getProduct().getPrice().multiply(BigDecimal.valueOf(getAmount()));
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
