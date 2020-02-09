package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.CartDAO;
import com.kilopo.kosshop.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl extends BaseDAOImpl<Cart> implements CartDAO {
    public CartDAOImpl(){
        super(Cart.class);
    }
}
