package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.ProducerDAO;
import com.kilopo.kosshop.service.ProducerService;
import com.kilopo.kosshop.entity.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ProducerDAO producerDAO;

    public boolean addProducer(Producer producer) {
        return producerDAO.addOrUpdate(producer) != null;
    }
}
