package com.hritvik.UniversityEventManagement.service;

import com.hritvik.UniversityEventManagement.model.Event;
import com.hritvik.UniversityEventManagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;


    public String addEvent(Event event) {
        eventRepo.save(event);
        return"Event Added";
    }

    public String UpdateEvent(Event event) {
        eventRepo.save(event);
        return"Event Updated";
    }

    public String DeleteEvent(Long eventId) {
        eventRepo.deleteById(eventId);
        return "Event Deleted";
    }

//    public Iterable<Event> getAllEventByDate(LocalDate date) {
//        ArrayList<Event> original = new ArrayList<>();
//        for(Event event :eventRepo.findAll()){
//            if(event.getDate().isEqual(date)){
//                original.add(event);
//            }
//        }
//        return original;
//    }

    public Iterable<Event> getAllEventByDate(LocalDate date) {
        return eventRepo.getAllEventByDate(date);
    }

    public Iterable<Event> getAllEvents() {
        return eventRepo.findAll();
    }


}
