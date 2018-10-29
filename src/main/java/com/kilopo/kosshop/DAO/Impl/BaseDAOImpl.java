package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.BaseDAO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BaseDAOImpl<T> implements BaseDAO<T> {
    @Autowired
    private Logger logger;

    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public BaseDAOImpl() {
    }

    public BaseDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T getById(Long id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> getByColumnNameAndValue(String name, Object value) {
        StringBuilder stringBuilder = new StringBuilder("FROM ")
                .append(entityClass.getName())
                .append(" AS a WHERE a.")
                .append(name)
                .append("= :value");
        Query query = entityManager.createQuery(stringBuilder.toString());
        query.setParameter("value", value);
        List<T> list = query.getResultList();
        return list;
    }

    @Transactional
    public T addOrUpdate(T value) {
        entityManager.merge(value);
        return value;
    }

    @Transactional
    public boolean delete(Long id) {
        try {
            StringBuilder stringBuilder = new StringBuilder("DELETE FROM")
                    .append(entityClass.getName())
                    .append(" AS a WHERE a.id = :id");
            Query query = entityManager.createQuery(stringBuilder.toString());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    public List getAll() {
        List<T> list = null;
        Query query = entityManager.createQuery("FROM " + entityClass.getName() + " AS a ORDER BY a.id");
        list = query.getResultList();
        return list;
    }
}
