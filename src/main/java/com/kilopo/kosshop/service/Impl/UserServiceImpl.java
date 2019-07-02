package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.UserDAO;
import com.kilopo.kosshop.entity.Role;
import com.kilopo.kosshop.entity.User;
import com.kilopo.kosshop.service.AddressService;
import com.kilopo.kosshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AddressService addressService;


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
        }
        return userDetails;
    }

    @Override
    public List<User> getByColumnNameAndValue(String name, Object value) {
        return userDAO.getByColumnNameAndValue(name, value);
    }

    @Override
    public User signUp(User user) {
        user.setRegistrationDate(new Date());
        user.setRole(Role.USER);
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setAddress(addressService.addOrGetId(user.getAddress()));
        return add(user);
    }

    @Override
    public User add(User user) {
        return userDAO.add(user);
    }
}
