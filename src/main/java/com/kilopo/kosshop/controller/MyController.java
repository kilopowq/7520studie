package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.DAO.ProducerDAO;
import com.kilopo.kosshop.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProducerDAO producerDAO;

    @RequestMapping(value = "/home3", method = RequestMethod.GET)
    public String home3() {
        return "home3";
    }

    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String home2() {
        return "home2";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return Constants.View.HOME_PAGE;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchPage() {
        return Constants.View.SEARCH_PAGE;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(ModelMap modelmap) {
        modelmap.addAttribute("categories", categoryDAO.getAll());
        modelmap.addAttribute("producers", producerDAO.getAll());
        return Constants.View.ADD_PAGE;
    }
}
