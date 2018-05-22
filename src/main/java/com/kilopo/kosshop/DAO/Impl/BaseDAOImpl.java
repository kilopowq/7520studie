package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.BaseDAO;
import com.kilopo.kosshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public class BaseDAOImpl<T> implements BaseDAO {
    private final Class<T> entityClass;

    BaseDAOImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T getById(Long id) {
        List<T> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                Query query = session.createQuery("FROM " + entityClass.getName() + " AS a WHERE a.id = ?");
                query.setParameter(0, id);
                list = query.list();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
            Optional<T> first = list.stream().findFirst();
            return first.orElse(null);
        }
    }

    public boolean delete(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                Query query = session.createQuery("DELETE FROM " + entityClass.getName() + " AS a WHERE a.id = ?");
                query.setParameter(0, id);
                query.executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }

    public List getAll() {
        List<T> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                Query query = session.createQuery("FROM " + entityClass.getName() + " AS a ORDER BY a.id");
                list = query.list();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
            return list;
        }
    }

    public boolean addOrUpdate(Object value) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                session.saveOrUpdate(value);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }
}
