package com.kilopo.kosshop.DAO.Impl;

import com.kilopo.kosshop.DAO.AddressDAO;
import com.kilopo.kosshop.entity.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl extends BaseDAOImpl<Address> implements AddressDAO {

    public AddressDAOImpl() {
        super(Address.class);
    }
}
