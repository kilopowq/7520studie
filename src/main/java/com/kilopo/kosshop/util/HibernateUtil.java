package com.kilopo.kosshop.util;

import com.kilopo.kosshop.entity.Address;
import com.kilopo.kosshop.entity.Category;
import com.kilopo.kosshop.entity.Order;
import com.kilopo.kosshop.entity.OrderProduct;
import com.kilopo.kosshop.entity.Producer;
import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.util.Properties;

public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/kosshop");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "root");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");
        Configuration cfg = new Configuration().setProperties(properties);
        cfg.addAnnotatedClass(Address.class);
        cfg.addAnnotatedClass(Category.class);
        cfg.addAnnotatedClass(Order.class);
        cfg.addAnnotatedClass(OrderProduct.class);
        cfg.addAnnotatedClass(Producer.class);
        cfg.addAnnotatedClass(Product.class);
        cfg.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        return cfg.buildSessionFactory(builder.build());
    }
}
