package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.ProductDAO;
import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    public boolean add(Product product) {
        return productDAO.addOrUpdate(product) != null;
    }

    public List<Product> searchByFields(Map<String, String> mapProductParam) {
        Map<String, String> filteredmap = mapProductParam.entrySet().stream().filter(mapEntry -> !mapEntry.getValue()
                .equals("")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return productDAO.findByFields(filteredmap);
    }
}
