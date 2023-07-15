package com.hritvik.MappingPracticeAssignment.service;

import com.hritvik.MappingPracticeAssignment.model.Student;
import com.hritvik.MappingPracticeAssignment.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    IStudentRepo studentRepo;

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Student saved";
    }
}
