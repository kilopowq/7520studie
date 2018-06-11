package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.BaseDAO;
import com.kilopo.kosshop.util.DatabaseConfig;
import com.kilopo.kosshop.util.HibernateUtil;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Repository
public class BaseDAOImpl<T> implements BaseDAO<T> {
    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager ;

    BaseDAOImpl() {
          entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T getNewId(Long id){
        List<T> list = null;


        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("FROM " + entityClass.getName() + " AS a WHERE a.id = ?");
        list = query.getResultList();
        Optional<T> first = list.stream().findFirst();

        return first.orElse(null);
    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public boolean addOrUpdate(Object value) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List getAll() {
        return null;
    }

   /* public T getById(Long id) {
        List<T> list = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                session.beginTransaction();
                Query query = session.createQuery("FROM " + entityClass.getName() + " AS a WHERE a.id = ?");
                query.setParameter(0, id);
               // list = query.list();
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
               // list = query.list();
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
    }*/
}
