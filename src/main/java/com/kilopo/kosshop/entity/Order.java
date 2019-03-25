package com.kilopo.kosshop.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private Double sum;
    private Date date;
    private OrderStatus orderStatus;
    private User user;
    private Set<OrderProduct> orderProducts;

    @Column
    @NotNull
    public Double getSum() {
        return sum;
    }

    @Column
    @NotNull
    public Date getDate() {
        return date;
    }

    @Enumerated(EnumType.STRING)
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    @OneToMany
    @JoinColumn(name = "order_id")
    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
