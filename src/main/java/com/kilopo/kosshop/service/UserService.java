package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.User;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {
    List<User> getByColumnNameAndValue(String name, Object value);
    User signUp(User user);
    User addOrUpdate(User user);
    boolean sentLinkToApproveNewAccount(User user);
    boolean approveNewAccount(String login);
    void deleteTerminatedUnapprovedUser();
}
