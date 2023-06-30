package com.hritvik.UniversityEventManagement.service;

import com.hritvik.UniversityEventManagement.model.Event;
import com.hritvik.UniversityEventManagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

    public List<Event> getEventByDate(LocalDate date) {

        List<Event> original = new List<Event>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Event> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Event event) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Event> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Event> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Event get(int index) {
                return null;
            }

            @Override
            public Event set(int index, Event element) {
                return null;
            }

            @Override
            public void add(int index, Event element) {

            }

            @Override
            public Event remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Event> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Event> listIterator(int index) {
                return null;
            }

            @Override
            public List<Event> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

           for(Event event :eventRepo.findAll()){
               if(event.getDate().equals(date)){
                   original.add(event);
               }
           }
           return original;
      }
}
