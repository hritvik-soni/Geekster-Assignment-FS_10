package com.hritvik.DoctorAPP.repository;

import com.hritvik.DoctorAPP.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor,Long> {
}
