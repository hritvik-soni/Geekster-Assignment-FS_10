package com.hritvik.InstaBackend.repository;

import com.hritvik.InstaBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String newEmail);
}
