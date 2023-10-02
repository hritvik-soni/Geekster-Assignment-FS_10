package com.hritvik.SpringBootTechnicalAssignment.service;


import com.hritvik.SpringBootTechnicalAssignment.model.Patient;
import com.hritvik.SpringBootTechnicalAssignment.repository.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private IPatientRepo patientRepo;


    public String addPatient(Patient patient) {
       Patient patient1 =patientRepo.findByPatientEmail(patient.getPatientEmail());
        if(patient1!=null){
            return "Patient Already Exist";
        }
        patient.setPatientCity(patient.getPatientCity().toUpperCase());
        patientRepo.save(patient);
        return "Patient Saved Successfully";
    }

    public String removePatient(Integer patientId) {
        if(patientRepo.findById(patientId).isEmpty()){
            return "Patient Id  Doesn't Exist";
        }
        patientRepo.deleteById(patientId);
        return "Patient Removed Successfully";
    }

    public String updatePatient(Integer patientId, Patient patient) {
        Patient currpatient = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Invalid Patient ID"));

        if(patient.getPatientCity() !=null){
            currpatient.setPatientCity(patient.getPatientCity());
        }
        if(patient.getPatientPhoneNumber() !=null){
            currpatient.setPatientPhoneNumber(patient.getPatientPhoneNumber());
        }
        if(patient.getPatientName() !=null){
            return"You cannot change Name";
        }
        if(patient.getPatientEmail()!=null){
            return"You cannot change Email";
        }
        if(patient.getPatientSymptoms()!=null){
           currpatient.setPatientSymptoms(patient.getPatientSymptoms());
        }
        patientRepo.save(currpatient);
        return "Patient Details Updated Successfully";
    }

    public Optional<Patient> getPatient(Integer patientId) {
        return patientRepo.findById(patientId);
    }
}
