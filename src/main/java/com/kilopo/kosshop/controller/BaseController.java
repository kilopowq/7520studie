package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.DAO.ProducerDAO;
import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.Cart;
import com.kilopo.kosshop.entity.Color;
import com.kilopo.kosshop.service.CartService;
import com.kilopo.kosshop.service.CategoryService;
import com.kilopo.kosshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProducerDAO producerService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap modelmap) {
        modelmap.addAttribute("products", productService.getAll());
        modelmap.addAttribute("categories", categoryService.getAll());
        return Constants.View.HOME_PAGE;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(ModelMap modelmap) {
        modelmap.addAttribute("categories", categoryService.getAll());
        modelmap.addAttribute("producers", producerService.getAll());
        modelmap.addAttribute("colors", Color.values());
        return Constants.View.ADD_PAGE;
    }

    @RequestMapping(value="/products_view", method = RequestMethod.GET)
    public String getCart() {
        return Constants.View.PRODUCTS_VIEW;
    }
}
