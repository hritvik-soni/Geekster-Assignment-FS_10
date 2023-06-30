package com.hritvik.UniversityEventManagement.controller;

import com.hritvik.UniversityEventManagement.model.Event;
import com.hritvik.UniversityEventManagement.model.Student;
import com.hritvik.UniversityEventManagement.service.EventService;
import com.hritvik.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController

public class UniversityController {

    @Autowired
    EventService eventService;
    @Autowired
    StudentService studentService;

    // Apis for Students
    @GetMapping("students")
    public Iterable<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("student/{studentId}/search")
    public Student getStudentbyid(@PathVariable Long studentId)
    {
        return studentService.getStudentbyid(studentId);
    }

    @PostMapping("student")
    public String addStudent (@RequestBody @Valid Student student)
    {
        return studentService.addStudent(student);
    }
    @PostMapping("students")
    public String addStudents (@RequestBody @Valid List<Student> student)
    {
        return studentService.addStudents(student);
    }

    @PutMapping("student")

    public String UpdateStudentDepartment (@RequestBody @Valid Student student)
    {
        return studentService.UpdateStudentDepartment(student);
    }
    @DeleteMapping("student/{studentId}/delete/")

    public String DeleteStudent(@PathVariable Long studentId)
    {
        return studentService.DeleteStudent(studentId);
    }

    // Apis for Events

// Add event
//Update event
//Delete event
//Get All events by date


    @PostMapping("event")
    public String addEvent (@RequestBody @Valid Event event)
    {
        return eventService.addEvent(event);
    }

    @PutMapping("event")
    public String UpdateEvent (@RequestBody @Valid Event event)
    {
        return eventService.UpdateEvent(event);
    }

    @DeleteMapping("event/{eventId}/delete")
    public String DeleteEvent (@PathVariable Long eventId)
    {
        return eventService.DeleteEvent(eventId);
    }


    @GetMapping("event/search")
    public Event getEventByDate (@RequestParam("date") @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate date){
        return eventService.getEventByDate(date);
    }

    @GetMapping("events/search")
    public Iterable<Event> getAllEventByDate (@RequestParam("date") @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate date){
        return eventService.getAllEventByDate(date);
    }

    @GetMapping("events")
    public Iterable<Event> getAllEvents()
    {
        return eventService.getAllEvents();
    }



}
