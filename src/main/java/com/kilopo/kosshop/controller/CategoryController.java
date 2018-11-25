package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.Category;
import com.kilopo.kosshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory(@RequestParam("name") String name){
        categoryService.add(new Category(name));
        return Constants.View.ADD_PAGE;
    }
}
