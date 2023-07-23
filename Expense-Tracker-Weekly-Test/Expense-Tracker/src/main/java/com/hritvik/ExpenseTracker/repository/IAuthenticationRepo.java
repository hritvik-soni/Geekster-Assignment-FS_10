package com.hritvik.ExpenseTracker.repository;

import com.hritvik.ExpenseTracker.model.AuthenticationToken;

import com.hritvik.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
