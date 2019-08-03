package com.kilopo.kosshop.DAO;

import com.kilopo.kosshop.entity.User;

public interface UserDAO extends BaseDAO<User> {
    void remove(User user);
}
