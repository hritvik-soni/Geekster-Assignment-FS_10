package com.hritvik.SpringBootTechnicalAssignment.controller;


import com.hritvik.SpringBootTechnicalAssignment.model.Patient;
import com.hritvik.SpringBootTechnicalAssignment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/new")
    public String addPatient(@RequestBody Patient patient){

        return patientService.addPatient(patient);
    }

    @DeleteMapping("/remove")
    public String removePatient(@RequestParam("id") Integer patientId){
        return patientService.removePatient(patientId);
    }
    @PutMapping("/update")

    public String updatePatient(@RequestParam("id") Integer patientId, @RequestBody Patient patient ){
        return patientService.updatePatient(patientId,patient);
    }

    @GetMapping("/search")
    public Optional<Patient> getPatient(@RequestParam("id") Integer patientId ){
        return patientService.getPatient(patientId);
    }
}
