package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.DAO.CategoryDAO;
import com.kilopo.kosshop.DAO.ProductDAO;
import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("Product") Product product) {
        productService.add(product);
        return Constants.View.ADD_PAGE;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchByProduct(ModelMap modelmap) {
        modelmap.addAttribute("products", productDAO.getAll());
        modelmap.addAttribute("categories", categoryDAO.getAll());
        return Constants.View.PRODUCTS_PAGE;
    }

    @RequestMapping(value = "/searchByCategory", method = RequestMethod.GET)
    public String searchProductByCategory(@RequestParam String categoryName,ModelMap modelmap) {
        modelmap.addAttribute("products",
                productDAO.getByColumnNameAndValue("category.name",categoryName));
        modelmap.addAttribute("categories",categoryDAO.getAll());
        modelmap.addAttribute("categoryActive",categoryName);
        return Constants.View.PRODUCTS_PAGE;
    }
}
