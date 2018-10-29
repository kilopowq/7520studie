package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Producer;

import java.util.List;

public interface ProducerService {
    boolean addProducer(Producer producer);
    List<Producer> findByName(String name);
}
