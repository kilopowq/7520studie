package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.service.CategoryService;
import com.kilopo.kosshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("Product") Product product, @RequestParam("myImage") MultipartFile myImage) {
        productService.add(product, myImage);
        return Constants.View.ADD_PAGE;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchByProduct(ModelMap modelmap) {
        modelmap.addAttribute("products", productService.getAll());
        modelmap.addAttribute("categories", categoryService.getAll());
        return Constants.View.PRODUCTS_PAGE;
    }

    @RequestMapping(value = "/searchByCategory", method = RequestMethod.GET)
    public String searchProductByCategory(@RequestParam("categoryName") String categoryName, ModelMap modelmap) {
        modelmap.addAttribute("products",
                productService.getByColumnNameAndValue("category.name", categoryName));
        modelmap.addAttribute("categories", categoryService.getAll());
        modelmap.addAttribute("categoryActive", categoryName);
        return Constants.View.PRODUCTS_PAGE;
    }
}
