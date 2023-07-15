package com.hritvik.RestaurantManagementServiceAPI.repository;

import com.hritvik.RestaurantManagementServiceAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String email);
}
