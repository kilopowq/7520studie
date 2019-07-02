package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.AddressDAO;
import com.kilopo.kosshop.entity.Address;
import com.kilopo.kosshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDAO addressDAO;

    @Override
    public Address addOrGetId(Address address) {
        Map<String, String> addressField = new HashMap<>();
        if (nonNull(address.getCity())) {
            addressField.put("city", address.getCity());
        }
        if (nonNull(address.getStreet())) {
            addressField.put("street", address.getStreet());
        }
        if (nonNull(address.getHouse())) {
            addressField.put("house", address.getHouse());
        }
        if (nonNull(address.getApartment())) {
            addressField.put("apartment", address.getApartment().toString());
        }
        List<Address> addresses = addressDAO.findByFields(addressField);
        Optional<Address> addressOptional = addresses.stream().findFirst();
        if (addressOptional.isPresent()) {
            System.out.println(addressOptional.orElse(null));
            System.out.println("id = " + addressOptional.get().getId());
            return addressOptional.get();
        } else {
            return addressDAO.add(address);
        }
    }
}
