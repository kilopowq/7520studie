package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.User;
import com.kilopo.kosshop.service.UserService;
import com.kilopo.kosshop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

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
            model.addAttribute("successfullySignedUp", userService.signUp(user).getLogin());
            return Constants.View.HOME_PAGE;
        }
    }
}
