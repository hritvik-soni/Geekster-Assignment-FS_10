package com.hritvik.EcommerceAPI.repository;

import com.hritvik.EcommerceAPI.model.Order;
;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends CrudRepository<Order,Long> {
}
