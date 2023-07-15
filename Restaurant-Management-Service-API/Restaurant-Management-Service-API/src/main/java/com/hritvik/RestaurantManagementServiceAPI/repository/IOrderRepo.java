package com.hritvik.RestaurantManagementServiceAPI.repository;

import com.hritvik.RestaurantManagementServiceAPI.model.Order;
import com.hritvik.RestaurantManagementServiceAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Long> {
    Order findFirstByUser(User user);
}
