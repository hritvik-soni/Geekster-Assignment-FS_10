package com.hritvik.UniversityEventManagement.repository;

import com.hritvik.UniversityEventManagement.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student,Long> {
}
