package com.hritvik.DoctorAPP.service;


import com.hritvik.DoctorAPP.model.Doctor;
import com.hritvik.DoctorAPP.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    IDoctorRepo doctorRepo;


    public void addDoctor(Doctor doc) {
        doctorRepo.save(doc);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }
}
