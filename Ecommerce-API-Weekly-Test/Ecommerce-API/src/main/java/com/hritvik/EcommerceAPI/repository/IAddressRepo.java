package com.hritvik.EcommerceAPI.repository;

import com.hritvik.EcommerceAPI.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends CrudRepository<Address,Long> {
}
