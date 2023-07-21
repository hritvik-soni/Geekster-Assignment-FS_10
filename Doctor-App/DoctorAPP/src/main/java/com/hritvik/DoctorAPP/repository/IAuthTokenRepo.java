package com.hritvik.DoctorAPP.repository;

import com.hritvik.DoctorAPP.model.AuthenticationToken;
import com.hritvik.DoctorAPP.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByPatient(Patient patient);
}
