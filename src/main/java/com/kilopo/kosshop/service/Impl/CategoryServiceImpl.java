package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.service.CategoryService;
import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    public boolean addCategory(Category category) {
        return categoryDAO.addOrUpdate(category).getId() != null;
    }
}
