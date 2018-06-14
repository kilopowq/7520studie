package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.UserDAO;
import com.kilopo.kosshop.entity.User;

public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    public UserDAOImpl(){
        super(User.class);
    }
}
