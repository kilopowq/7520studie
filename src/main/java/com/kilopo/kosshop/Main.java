package com.kilopo.kosshop;

import com.kilopo.kosshop.DAO.Impl.AddressDAOImpl;
import com.kilopo.kosshop.DAO.Impl.CategoryDAOImpl;
import com.kilopo.kosshop.DAO.Impl.UserDAOImpl;
import com.kilopo.kosshop.entity.Address;
import com.kilopo.kosshop.util.DatabaseConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args)throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DatabaseConfig.class);
        context.refresh();
        AddressDAOImpl a = new AddressDAOImpl();
        Address aa = a.getNewId(2L);
        System.out.println(aa);

    }
}
