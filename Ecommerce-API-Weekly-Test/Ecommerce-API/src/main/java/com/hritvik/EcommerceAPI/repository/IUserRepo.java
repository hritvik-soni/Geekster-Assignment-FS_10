package com.hritvik.EcommerceAPI.repository;

import com.hritvik.EcommerceAPI.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User,Long> {
}
