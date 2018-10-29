package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.entity.Category;
import com.kilopo.kosshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    public boolean addCategory(Category category) {
        return categoryDAO.addOrUpdate(category).getId() != null;
    }

    public List<Category> findByName(String name) {
        List<Category> categorys = categoryDAO.getByColumnNameAndValue("name", name);
        return categorys;
    }

    public List<Category> findByProducerName(String producerName) {
        List<Category> categorys = categoryDAO.findByProducerName(producerName);
        return categorys;
    }

}
