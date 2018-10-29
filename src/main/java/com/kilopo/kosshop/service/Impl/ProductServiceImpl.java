package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.DAO.ProducerDAO;
import com.kilopo.kosshop.DAO.ProductDAO;
import com.kilopo.kosshop.entity.Category;
import com.kilopo.kosshop.entity.Producer;
import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProducerDAO producerDAO;

    public boolean addProduct(Product product) {
        return productDAO.addOrUpdate(product) != null;
    }

    public List<Product> findByName(String name) {
        List<Product> products = productDAO.getByColumnNameAndValue("name", name);
        return products;
    }

    public List<Product> findByCategoryName(String categoryName) {
        List<Product> products = null;
        List<Category> list = categoryDAO.getByColumnNameAndValue("name", categoryName);
        Optional<Category> first = list.stream().findFirst();
        if (first.isPresent()) {
            products = productDAO.getByColumnNameAndValue("category", first.get());
        }
        return products;
    }

    public List<Product> findByProducerName(String producerName) {
        List<Product> products = null;
        List<Producer> list = producerDAO.getByColumnNameAndValue("name", producerName);
        Optional<Producer> first = list.stream().findFirst();
        if (first.isPresent()) {
            products = productDAO.getByColumnNameAndValue("producer", first.get());
        }
        return products;
    }
}
