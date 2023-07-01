package com.hritvik.UniversityEventManagement.service;

import com.hritvik.UniversityEventManagement.model.Department;
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

    /**
     *
     * @return
     */
    public Iterable<Student> getAllStudents() {

        return studentRepo.findAll();
    }

    /**
     *
     * @param studentId
     * @return
     */

    public Student getStudentbyid(Long studentId) {
        Optional<Student> optional= studentRepo.findById(studentId);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /**
     *
     * @param student
     * @return
     */
    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Added";
    }

    /**
     *
     * @param student
     * @return
     */

    public String addStudents(List<Student> student) {
        studentRepo.saveAll(student);
        return "Added";
    }

    /**
     *
     * @param studentId
     * @param department
     * @return
     */
    public String UpdateStudentDepartment(Long studentId, Department department) {

        if(studentRepo.existsById(studentId)){
           Student student= getStudentbyid(studentId);
           student.setDepartment(department);
           studentRepo.save(student);
            return "Student Updated";
        }
        else{
            return "Student Id does not exist";
        }
    }

    /**
     *
     * @param studentId
     * @return
     */
    public String DeleteStudent(Long studentId) {

        if(studentRepo.existsById(studentId)){
            studentRepo.deleteById(studentId);
            return "Student Deleted";
        }
        else{
            return "Student Id does not exist";
        }


    }
}
