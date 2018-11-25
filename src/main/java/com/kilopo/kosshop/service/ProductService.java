package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Product;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

public interface ProductService {
    boolean add(Product product, MultipartFile image);
    List<Product> searchByFields(Map<String,String> mapProductParam);
    List<Product> getAll();
    List<Product> getByColumnNameAndValue(String name,Object value);
}
