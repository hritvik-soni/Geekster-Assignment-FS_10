package com.hritvik.MappingPracticeAssignment.controller;

import com.hritvik.MappingPracticeAssignment.model.Laptop;
import com.hritvik.MappingPracticeAssignment.model.Student;
import com.hritvik.MappingPracticeAssignment.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {
@Autowired
    LaptopService  laptopService;
    @PostMapping("laptop")
    public void addLaptop(@RequestBody Laptop laptop)
    {
        laptopService.addLaptop(laptop);
    }
}
