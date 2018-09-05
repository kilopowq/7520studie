package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.ProductDAO;
import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.service.ProductService;
import com.kilopo.kosshop.entity.Category;
import com.kilopo.kosshop.entity.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    public boolean addProduct(Product product) {
        return productDAO.addOrUpdate(product) != null;
    }

    public List<Product> findByName(String name) {
        List<Product> products = productDAO.getByColumnNameAndValue("name", name);
        return products;
    }

    public List<Product> findByCategory(Category category) {
        List<Product> products = productDAO.getByColumnNameAndValue("category", category);
        return products;
    }

    public List<Product> findByProducer(Producer producer) {
        List<Product> products = productDAO.getByColumnNameAndValue("producer", producer);
        return products;
    }
}
