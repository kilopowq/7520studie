package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.OrderDAO;
import com.kilopo.kosshop.entity.Order;

public class OrderDAOImpl extends BaseDAOImpl<Order> implements OrderDAO {

    public OrderDAOImpl(){
        super(Order.class);
    }
}
