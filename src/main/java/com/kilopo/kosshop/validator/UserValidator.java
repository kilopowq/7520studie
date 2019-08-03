package com.kilopo.kosshop.validator;

import com.kilopo.kosshop.entity.User;
import com.kilopo.kosshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;

import static java.util.Objects.nonNull;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver resolver;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass) || User.class.equals(aClass);
    }

    @Override
    public void validate(Object objectUser, Errors errors) {
        User user = (User) objectUser;

        Locale l = LocaleContextHolder.getLocale();
        MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource, l);

        if (nonNull(user.getPhone())) {
            if (user.getPhone() < 380500000000L || user.getPhone() > 380999999999L) {
                errors.rejectValue("phone", "already exist", messageSourceAccessor.getMessage("this.phone.number.is.Invalid"));
            }
        }

        List<User> loginUser = userService.getByColumnNameAndValue("login", user.getLogin());
        List<User> emailUser = userService.getByColumnNameAndValue("email", user.getEmail());
        List<User> phoneUser = userService.getByColumnNameAndValue("phone", user.getPhone());

        if (!emailUser.isEmpty()) {
            errors.rejectValue("email", "already exist", messageSourceAccessor.getMessage("such.email.already.exist"));
        } else if (!loginUser.isEmpty()) {
            errors.rejectValue("login", "already exist", messageSourceAccessor.getMessage("such.login.already.exist"));
        } else if (!phoneUser.isEmpty()) {
            errors.rejectValue("phone", "already exist", messageSourceAccessor.getMessage("such.phone.already.exist"));
        }

    }




}
