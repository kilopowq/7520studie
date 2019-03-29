package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.UserDAO;
import com.kilopo.kosshop.entity.User;
import com.kilopo.kosshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.getByColumnNameAndValue("login", login).stream().findFirst().orElse(null);
        Set<GrantedAuthority> roles = new HashSet<>();
        UserDetails userDetails = null;
        if (nonNull(user)) {
            roles.add(new SimpleGrantedAuthority(user.getRole().name()));
            userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
                    user.getPassword(),
                    roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return userDetails;
    }

}
