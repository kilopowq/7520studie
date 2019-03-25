package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.UserDAO;
import com.kilopo.kosshop.entity.User;
import com.kilopo.kosshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUser(String login) {
        return userDAO.getByColumnNameAndValue("login", login).stream().findFirst().orElse(null);
    }

}
