package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Category;

import java.util.List;

public interface CategoryService {
    boolean addCategory(Category category);
    List<Category> findByName(String name);
    List<Category> findByProducerName(String producerName);
}
