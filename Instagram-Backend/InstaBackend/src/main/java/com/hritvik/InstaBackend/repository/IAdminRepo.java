package com.hritvik.InstaBackend.repository;

import com.hritvik.InstaBackend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}
