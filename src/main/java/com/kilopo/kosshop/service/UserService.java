package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.User;

import java.util.List;

public interface UserService {
    List<User> getByColumnNameAndValue(String name, Object value);
    User signUp(User user);
    User add(User user);
}
