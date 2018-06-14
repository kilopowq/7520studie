package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.ProducerDAO;
import com.kilopo.kosshop.entity.Producer;

public class ProducerDAOImpl extends BaseDAOImpl<Producer> implements ProducerDAO {

    public ProducerDAOImpl(){
        super(Producer.class);
    }
}
