package com.hritvik.SpringBootTechnicalAssignment.repository;


import com.hritvik.SpringBootTechnicalAssignment.model.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepo  extends JpaRepository<Doctor,Integer> {
   Doctor findByDoctorEmail(String doctorEmail);


    List<Doctor> findByDoctorSpeciality(String speciality);
}
