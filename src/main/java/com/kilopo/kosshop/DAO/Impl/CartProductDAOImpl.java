package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.CartProductDAO;
import com.kilopo.kosshop.entity.CartProduct;
import org.springframework.stereotype.Repository;

@Repository
public class CartProductDAOImpl extends BaseDAOImpl<CartProduct> implements CartProductDAO {
    public CartProductDAOImpl() {
        super(CartProduct.class);
    }
}
