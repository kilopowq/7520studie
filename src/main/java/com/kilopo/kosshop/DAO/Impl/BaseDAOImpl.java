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
import java.util.Map;

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
        return query.getResultList();
    }

    @Transactional
    public T addOrUpdate(T value) {
        entityManager.merge(value);
        return value;
    }

    @Transactional
    public T add(T value) {
        entityManager.persist(value);
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
            logger.error(e.getMessage(),e);
            return false;
        }
    }

    public List getAll() {
        StringBuilder stringBuilder = new StringBuilder("FROM ")
                .append(entityClass.getName())
                .append(" AS a ORDER BY a.id");
        Query query = entityManager.createQuery(stringBuilder.toString());
        return query.getResultList();
    }

    public List findByFields(Map<String, String> allParams) {
        boolean count = true;
        StringBuilder stringBuilder = new StringBuilder("FROM ")
                .append(entityClass.getName())
                .append(" WHERE");
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (count) {
                    stringBuilder.append(" " + entry.getKey() + " = \'" + entry.getValue() + "\'");
                    count = false;
            } else {
                    stringBuilder.append(" AND " + entry.getKey() + " = \'" + entry.getValue() + "\'");
            }
        }
        Query query = entityManager.createQuery(stringBuilder.toString());
        return query.getResultList();
    }
}
