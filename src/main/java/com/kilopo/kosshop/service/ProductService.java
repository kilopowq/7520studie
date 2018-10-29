package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.entity.Category;
import com.kilopo.kosshop.entity.Producer;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    List<Product> findByName(String name);
    List<Product> findByCategoryName(String categoryName);
    List<Product> findByProducerName(String producerName);
}
