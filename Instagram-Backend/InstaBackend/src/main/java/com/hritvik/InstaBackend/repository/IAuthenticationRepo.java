package com.hritvik.InstaBackend.repository;

import com.hritvik.InstaBackend.model.AuthenticationToken;
import com.hritvik.InstaBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
