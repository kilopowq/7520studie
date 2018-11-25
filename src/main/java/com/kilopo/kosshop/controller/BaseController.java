package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.DAO.ProducerDAO;
import com.kilopo.kosshop.DAO.ProductDAO;
import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProducerDAO producerDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap modelmap) {
        modelmap.addAttribute("products", productDAO.getAll());
        modelmap.addAttribute("categories", categoryDAO.getAll());
        return Constants.View.HOME_PAGE;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(ModelMap modelmap) {
        modelmap.addAttribute("categories", categoryDAO.getAll());
        modelmap.addAttribute("producers", producerDAO.getAll());
        modelmap.addAttribute("colors", Color.class.getEnumConstants());
        return Constants.View.ADD_PAGE;
    }
}
