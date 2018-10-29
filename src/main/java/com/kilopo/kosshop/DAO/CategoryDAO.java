package com.kilopo.kosshop.DAO;

import com.kilopo.kosshop.entity.Category;

import java.util.List;

public interface CategoryDAO extends BaseDAO<Category> {
    List<Category> findByProducerName(String producerName);
}
