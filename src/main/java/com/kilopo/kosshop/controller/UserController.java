package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.User;
import com.kilopo.kosshop.service.UserService;
import com.kilopo.kosshop.validator.UserValidator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
public class UserController {

    private static Logger logger;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @InitBinder
    protected void initBinder(final WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userValidator);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage(Model model) {
        model.addAttribute("User", new User());
        return Constants.View.REGISTRATION;
    }

    @RequestMapping(value = "/sign up", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String signUp(@ModelAttribute("User") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return Constants.View.REGISTRATION;
        } else {
            userService.sentLinkToApproveNewAccount(user);
            model.addAttribute("approvalLinkSended", userService.signUp(user).getLogin());
            return Constants.View.HOME_PAGE;
        }
    }

    @RequestMapping(value = "/registration/approve", method = RequestMethod.GET)
    public String registrationApprove(@RequestParam("Login") String login, Model model) {
        if (userService.approveNewAccount(login)) {
        } else {
            model.addAttribute("notApproved", true);
        }
        return Constants.View.HOME_PAGE;
    }
}
