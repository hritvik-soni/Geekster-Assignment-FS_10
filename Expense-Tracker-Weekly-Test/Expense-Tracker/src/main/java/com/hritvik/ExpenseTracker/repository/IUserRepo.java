package com.hritvik.ExpenseTracker.repository;

import com.hritvik.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {



     boolean existsByUserEmail(String userEmail);

    User findFirstByUserEmail(String signInEmail);
}
