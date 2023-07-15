package com.hritvik.MappingPracticeAssignment.service;

import com.hritvik.MappingPracticeAssignment.model.Laptop;
import com.hritvik.MappingPracticeAssignment.model.Student;
import com.hritvik.MappingPracticeAssignment.repository.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
@Autowired
    ILaptopRepo laptopRepo;
    public void addLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
    }
}
