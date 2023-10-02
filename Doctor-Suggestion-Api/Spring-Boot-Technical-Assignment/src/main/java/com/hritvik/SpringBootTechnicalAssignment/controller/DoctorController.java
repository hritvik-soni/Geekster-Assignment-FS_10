package com.hritvik.SpringBootTechnicalAssignment.controller;

import com.hritvik.SpringBootTechnicalAssignment.model.Doctor;
import com.hritvik.SpringBootTechnicalAssignment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/new")
    public String addDoctor(@RequestBody Doctor doctor){
       return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/remove")
    public String removeDoctor(@RequestParam("id") Integer doctorId){
        return doctorService.removeDoctor(doctorId);
    }
    @PutMapping("/update")

    public String updateDoctor(@RequestParam("id") Integer doctorId, @RequestBody Doctor doctor ){
        return doctorService.updateDoctor(doctorId,doctor);
    }

    @GetMapping("/search")
    public Optional<Doctor> getDoctor(@RequestParam("id") Integer doctorId ){
        return doctorService.getDoctor(doctorId);
    }




}
