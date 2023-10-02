package com.hritvik.SpringBootTechnicalAssignment.service;

import com.hritvik.SpringBootTechnicalAssignment.model.Doctor;
import com.hritvik.SpringBootTechnicalAssignment.model.Patient;
import com.hritvik.SpringBootTechnicalAssignment.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private IDoctorRepo doctorRepo;


    public String addDoctor(Doctor doctor) {

        if(doctorRepo.findByDoctorEmail(doctor.getDoctorEmail())!=null){
            return "Doctor Already Exist";
        }
        doctorRepo.save(doctor);
        return "Doctor Saved Successfully";

    }

    public String removeDoctor(Integer doctorId) {
        if(doctorRepo.findById(doctorId).isEmpty()){
            return "Doctor Id  Doesn't Exist";
        }
        doctorRepo.deleteById(doctorId);
        return "Doctor Removed Successfully";
    }

    public String updateDoctor(Integer doctorId, Doctor doctor) {
        Doctor currDoctor = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Invalid Doctor ID"));

        if(doctor.getDoctorCity() !=null){
            currDoctor.setDoctorCity(doctor.getDoctorCity());
        }
        if(doctor.getDoctorPhoneNumber() !=null){
            currDoctor.setDoctorPhoneNumber(doctor.getDoctorPhoneNumber());
        }
        if(doctor.getDoctorName() !=null){
           return"You cannot change Name";
        }
        if(doctor.getDoctorEmail()!=null){
            return"You cannot change Email";
        }
        if(doctor.getDoctorSpeciality()!=null){
            return"You cannot change Speciality ";
        }
         doctorRepo.save(currDoctor);
        return "Doctor Details Updated Successfully";

    }

    public Optional<Doctor> getDoctor(Integer doctorId) {
        return doctorRepo.findById(doctorId);

    }
}
