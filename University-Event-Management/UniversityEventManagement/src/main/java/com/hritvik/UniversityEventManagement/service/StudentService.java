package com.hritvik.UniversityEventManagement.service;

import com.hritvik.UniversityEventManagement.model.Student;

import com.hritvik.UniversityEventManagement.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepo studentRepo;

    public Iterable<Student> getAllStudents() {

        return studentRepo.findAll();
    }

    public Student getStudentbyid(Long studentId) {
        Optional<Student> optional= studentRepo.findById(studentId);
        if(optional.isEmpty()){
            return null;
        }
        return optional.get();
    }

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Added";
    }

    public String addStudents(List<Student> student) {
        studentRepo.saveAll(student);
        return "Added";
    }

    public String UpdateStudentDepartment(Student student) {
        studentRepo.save(student);
        return "Student Detail Updated";
    }

    public String DeleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
        return"Student Deleted";
    }
}
