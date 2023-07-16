package com.hritvik.InstagramBackendWeeklyTest.repository;

import com.hritvik.InstagramBackendWeeklyTest.model.AuthenticationToken;
import com.hritvik.InstagramBackendWeeklyTest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);

}
