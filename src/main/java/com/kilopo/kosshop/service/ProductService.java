package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Category;
import com.kilopo.kosshop.entity.Producer;
import com.kilopo.kosshop.entity.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    List<Product> findByName(String name);
    List<Product> findByCategory(Category category);
    List<Product> findByProducer(Producer producer);
}
