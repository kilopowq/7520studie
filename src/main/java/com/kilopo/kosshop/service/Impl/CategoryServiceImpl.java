package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.service.CategoryService;
import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category add(Category category) {
        List<Category> categories = categoryDAO.getAll();
        for (Category c : categories) {
            if (c.getName().equals(category.getName())) {
                return category;
            }
        }
        return categoryDAO.add(category);
    }
}
