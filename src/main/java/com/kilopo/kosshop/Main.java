package com.kilopo.kosshop;

import com.kilopo.kosshop.DAO.Impl.AddressDAOImpl;
import com.kilopo.kosshop.DAO.Impl.CategoryDAOImpl;
import com.kilopo.kosshop.DAO.Impl.UserDAOImpl;
import com.kilopo.kosshop.entity.Address;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)throws SQLException {
        AddressDAOImpl a = new AddressDAOImpl();
        Address aa = a.getById(2L);
        System.out.println(aa);

    }
}
