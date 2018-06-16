package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.ProductDAO;
import com.kilopo.kosshop.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl extends BaseDAOImpl<Product> implements ProductDAO {
    public ProductDAOImpl(){
        super(Product.class);
    }
}
