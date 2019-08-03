package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.UserDAO;
import com.kilopo.kosshop.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    public UserDAOImpl() {
        super(User.class);
    }

    @Transactional
    public void remove(User user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.merge(user);
        }

    }
}
