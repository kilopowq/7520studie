package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public void productName(WebRequest webRequest) {
        Map<String, String[]> parameters = webRequest.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            for (String name : entry.getValue()) {
                if(entry.getKey().equals("name")){
                    System.out.println(productService.findByName(name));
                }
                else if(entry.getKey().equals("categoryName")){
                    System.out.println(productService.findByCategoryName(name));
                }
                else if(entry.getKey().equals("producerName")){
                    System.out.println(productService.findByProducerName(name));
                }
            }
        }
    }
}
