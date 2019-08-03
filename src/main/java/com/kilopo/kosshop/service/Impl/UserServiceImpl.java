package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.UserDAO;
import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.Role;
import com.kilopo.kosshop.entity.User;
import com.kilopo.kosshop.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static java.util.Objects.nonNull;

@Service
@PropertySource(Constants.ProjectUrl.BASE_URL)
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private Logger logger;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Environment env;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.getByColumnNameAndValue("login", login).stream().filter(User::getApproval)
                .findFirst().orElse(null);
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
        fillUserInAddress(user);
        return addOrUpdate(user);
    }

    @Override
    public User addOrUpdate(User user) {
        return userDAO.addOrUpdate(user);
    }

    @Override
    public boolean sentLinkToApproveNewAccount(User user) {

        String from = "virginshop452@gmail.com";
        String password = "Usipav24";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                }
        );
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mail.smtp.auth"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
            message.setSubject("Dear visitor");
            StringBuilder approveMassage = new StringBuilder("This is approval link your registration: ")
                    .append(env.getRequiredProperty("project.name"))
                    .append("registration/approve/?Login=")
                    .append(user.getLogin());
            message.setContent(approveMassage.toString(), "text/html; charset=utf-8");
            Transport.send(message);

        } catch (MessagingException e) {
            logger.error(Message.class.getName() +" unable to sent approval link", e);
        }

        return true;
    }

    @Override
    public boolean approveNewAccount(String login) {
        //delete all terminated users
        deleteTerminatedUnapprovedUser();
        if (nonNull(login)) {
            List<User> userList = getByColumnNameAndValue("login", login);
            if (!userList.isEmpty()) {
                User user = userList.stream().findFirst().get();
                user.setApproval(true);
                addOrUpdate(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteTerminatedUnapprovedUser() {
        userDAO.getByColumnNameAndValue("approval", false)
                .stream().filter(user -> user.getRegistrationDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime().isBefore(LocalDateTime.now().minusDays(1)))
                .forEach(userDAO::remove);
    }

    public void fillUserInAddress(User user) {
        user.getAddress().stream().forEach(address -> address.setUser(user));
    }
}
