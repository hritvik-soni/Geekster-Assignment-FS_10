package com.hritvik.MappingPracticeAssignment.controller;

import com.hritvik.MappingPracticeAssignment.model.Course;
import com.hritvik.MappingPracticeAssignment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("course")
    public Iterable<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping("course")
    public void addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
    }

    @PutMapping("course/update/of")
    public String updateCourse(@RequestParam("courseId") Long courseId,@RequestParam("coursePrice") String courseTitle){
        return courseService.updateCourseTitle(courseId,courseTitle);
    }

    @DeleteMapping("course/delete/of")
    public String deleteCourse(@RequestParam("courseId") Long courseId){
        return courseService.deleteCourse(courseId);
    }
}
