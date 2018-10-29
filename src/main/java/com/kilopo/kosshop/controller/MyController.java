package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return Constants.View.HOMEPAGE;
    }

    @RequestMapping(value = "/lll", method = RequestMethod.GET)
    public void lol() {
        System.out.println("lol");
    }

    @RequestMapping(value = "/cat", method = RequestMethod.GET)
    public void lol1(WebRequest webRequest) {
        Map<String, String[]> parameters = webRequest.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            for (String s : entry.getValue()) {
                System.out.println(categoryService.findByName(s));
            }
        }
    }
}
