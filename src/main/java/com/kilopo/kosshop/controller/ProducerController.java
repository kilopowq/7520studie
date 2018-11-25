package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.Producer;
import com.kilopo.kosshop.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProducer(@RequestParam("name") String name) {
        producerService.add(new Producer(name));
        return Constants.View.ADD_PAGE;
    }
}
