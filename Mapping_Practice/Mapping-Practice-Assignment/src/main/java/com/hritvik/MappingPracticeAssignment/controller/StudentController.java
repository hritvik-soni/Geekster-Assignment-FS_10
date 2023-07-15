package com.hritvik.MappingPracticeAssignment.controller;

import com.hritvik.MappingPracticeAssignment.model.Student;
import com.hritvik.MappingPracticeAssignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("student")
    public String addStudent(@RequestBody Student student)
    {
         return studentService.addStudent(student);

    }
}
