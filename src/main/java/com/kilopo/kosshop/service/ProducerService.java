package com.kilopo.kosshop.service;

import com.kilopo.kosshop.entity.Producer;
import java.util.List;

public interface ProducerService {
    Producer add(Producer producer);
    List<Producer> getAll();
}
