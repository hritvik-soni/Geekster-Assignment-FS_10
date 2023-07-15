package com.hritvik.MappingPracticeAssignment.repository;


import com.hritvik.MappingPracticeAssignment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Long> {
}
