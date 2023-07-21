package com.hritvik.DoctorAPP.repository;

import com.hritvik.DoctorAPP.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}
