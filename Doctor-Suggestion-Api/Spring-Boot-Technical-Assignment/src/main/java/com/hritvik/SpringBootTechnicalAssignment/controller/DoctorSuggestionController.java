package com.hritvik.SpringBootTechnicalAssignment.controller;

import com.hritvik.SpringBootTechnicalAssignment.model.Doctor;
import com.hritvik.SpringBootTechnicalAssignment.model.enums.Speciality;
import com.hritvik.SpringBootTechnicalAssignment.service.DoctorSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suggestion")
public class DoctorSuggestionController {

    @Autowired
    DoctorSuggestionService service;

    @GetMapping("/search")
    public List<String> getDoctorList(@RequestParam("id") Integer patientId){
        return service.getDoctorList(patientId);
    }

    @GetMapping("/find")
    public List<Doctor> getDoctorListBySpeciality(@RequestParam Speciality speciality){
        return service.getDoctorListBySpeciality(speciality);
    }

}
