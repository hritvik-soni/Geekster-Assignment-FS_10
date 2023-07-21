package com.hritvik.DoctorAPP.repository;

import com.hritvik.DoctorAPP.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient,Long> {

    Patient findFirstByPatientEmail(String newEmail);
}
