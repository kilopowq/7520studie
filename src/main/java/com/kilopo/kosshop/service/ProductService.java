package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Product;
import java.util.List;
import java.util.Map;

public interface ProductService {
    boolean add(Product product);
    List<Product> searchByFields(Map<String,String> mapProductParam);
}
