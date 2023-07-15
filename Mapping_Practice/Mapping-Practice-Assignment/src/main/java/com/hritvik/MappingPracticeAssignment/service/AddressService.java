package com.hritvik.MappingPracticeAssignment.service;

import com.hritvik.MappingPracticeAssignment.model.Address;
import com.hritvik.MappingPracticeAssignment.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public void addAddress(Address address) {
        addressRepo.save(address);
    }
}
