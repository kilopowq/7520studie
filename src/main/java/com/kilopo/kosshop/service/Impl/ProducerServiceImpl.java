package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.ProducerDAO;
import com.kilopo.kosshop.service.ProducerService;
import com.kilopo.kosshop.entity.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ProducerDAO producerDAO;

    public Producer add(Producer producer) {
        List<Producer> producers = producerDAO.getAll();
        for (Producer p : producers) {
            if (p.getName().equals(producer.getName())) {
                return producer;
            }
        }
        return producerDAO.add(producer);
    }

    @Override
    public List<Producer> getAll() {
        return producerDAO.getAll();
    }
}
