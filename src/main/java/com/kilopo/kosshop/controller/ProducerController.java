package com.kilopo.kosshop.controller;

import com.kilopo.kosshop.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "/producer", method = RequestMethod.GET)
    public void producerName(WebRequest webRequest) {
        Map<String, String[]> parameters = webRequest.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            for (String name : entry.getValue()) {
                System.out.println(producerService.findByName(name));
            }
        }
    }
}
