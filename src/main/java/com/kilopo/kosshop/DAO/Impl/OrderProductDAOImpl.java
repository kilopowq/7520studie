package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.OrderProductDAO;
import com.kilopo.kosshop.entity.OrderProduct;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductDAOImpl extends BaseDAOImpl<OrderProduct> implements OrderProductDAO {
    public OrderProductDAOImpl(){
        super(OrderProduct.class);
    }
}
