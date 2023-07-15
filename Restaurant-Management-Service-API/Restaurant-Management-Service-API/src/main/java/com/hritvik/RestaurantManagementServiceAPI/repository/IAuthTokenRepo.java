package com.hritvik.RestaurantManagementServiceAPI.repository;

import com.hritvik.RestaurantManagementServiceAPI.model.AuthenticationToken;
import com.hritvik.RestaurantManagementServiceAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
