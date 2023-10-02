package com.hritvik.SpringBootTechnicalAssignment.repository;


import com.hritvik.SpringBootTechnicalAssignment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Integer> {
    Patient findByPatientEmail(String patientEmail);
}
