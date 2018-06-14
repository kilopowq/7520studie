package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.entity.Category;

public class CategoryDAOImpl extends BaseDAOImpl<Category> implements CategoryDAO {

    public CategoryDAOImpl(){
        super(Category.class);
    }
}
