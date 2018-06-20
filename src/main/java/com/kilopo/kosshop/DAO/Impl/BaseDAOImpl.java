package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.BaseDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BaseDAOImpl<T> implements BaseDAO<T> {
    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseDAOImpl() {
    }

    public BaseDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T getById(Long id) {
        return entityManager.find(entityClass, id);
    }

    @Transactional
    public T addOrUpdate(T value) {
        entityManager.merge(value);
        return value;
    }

    @Transactional
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM " + entityClass.getName() + " AS a WHERE a.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public List getAll() {
        List<T> list = null;
        Query query = entityManager.createQuery("FROM " + entityClass.getName() + " AS a ORDER BY a.id");
        list = query.getResultList();
        return list;
    }
}
