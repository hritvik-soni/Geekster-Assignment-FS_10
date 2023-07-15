package com.hritvik.MappingPracticeAssignment.repository;

import com.hritvik.MappingPracticeAssignment.model.Address;
import com.hritvik.MappingPracticeAssignment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course,Long> {
}
