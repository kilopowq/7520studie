package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Category;
import java.util.List;

public interface CategoryService {
    Category add(Category category);
    List<Category> getAll();
}
