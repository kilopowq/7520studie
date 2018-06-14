package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class BaseDAOImpl<T> implements BaseDAO<T> {
    private Class<T> entityClass;

    @Autowired
    private EntityManager entityManager;

    BaseDAOImpl() {

    }

    public BaseDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T getById(Long id) {
        List<T> list = null;
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("FROM " + entityClass.getName() + " AS a WHERE a.id = :id");
            query.setParameter("id", id);
            list = query.getResultList();
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        Optional<T> first = list.stream().findFirst();
        return first.orElse(null);
    }

    public boolean delete(Long id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("DELETE FROM " + entityClass.getName() + " AS a WHERE a.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List getAll() {
        List<T> list = null;
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery("FROM " + entityClass.getName() + " AS a ORDER BY a.id");
            list = query.getResultList();
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public boolean addOrUpdate(T value) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(value);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
