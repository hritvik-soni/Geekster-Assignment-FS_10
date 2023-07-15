package com.hritvik.MappingPracticeAssignment.service;

import com.hritvik.MappingPracticeAssignment.model.Course;
import com.hritvik.MappingPracticeAssignment.repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    ICourseRepo courseRepo;
    public void addCourse(Course course) {
        courseRepo.save(course);

    }
}
