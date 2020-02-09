package com.kilopo.kosshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table
public class Cart extends BaseEntity {
    private Set<CartProduct> cartProducts = new HashSet<>();
    private Date date;
    private CartStatus cartStatus;
    private User user;
    private BigDecimal sum;
    private Integer countOfProducts;

    public Cart() {
        date = new Date();
        cartStatus = CartStatus.ACTIVE;
    }

    public Cart(User user) {
        date = new Date();
        this.user = user;
        cartStatus = CartStatus.ACTIVE;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "cart", fetch = FetchType.EAGER)
    public Set<CartProduct> getCartProducts() {
        return cartProducts;
    }

    @Column
    @NotNull
    public Date getDate() {
        return date;
    }

    @Transient
    public BigDecimal getSum() {
        return getCartProducts().stream().map(CartProduct::getSum).collect(Collectors.toList())
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Enumerated(EnumType.STRING)
    public CartStatus getCartStatus() {
        return cartStatus;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    @Transient
    public int getCountOfProducts() {
        return cartProducts.stream().mapToInt(cartProducts -> cartProducts.getAmount()).sum();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCartProducts(Set<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
}
