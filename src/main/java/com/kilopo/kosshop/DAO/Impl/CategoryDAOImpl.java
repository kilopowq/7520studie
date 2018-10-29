package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDAOImpl extends BaseDAOImpl<Category> implements CategoryDAO {
    public CategoryDAOImpl(){
        super(Category.class);
    }

    @Override
    public List<Category> findByProducerName(String producerName) {
        StringBuilder stringBuilder = new StringBuilder("FROM ")
                .append("Category c")
                .append(" INNER JOIN Product pt")
                .append(" ON c.id = pt.Category.id")
                .append(" INNER JOIN Producer pr")
                .append(" ON pt.Producer.id = pr.id")
                .append(" WHERE pt.Producer.name")
                .append(" = :value");
        Query query = entityManager.createQuery(stringBuilder.toString());
        query.setParameter("value", producerName);
        System.out.println("LAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(query.getResultList());
        List<Category> list = query.getResultList();
        return list;
    }
}
