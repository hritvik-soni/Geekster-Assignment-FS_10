package com.hritvik.HotelManagement.service;

import com.hritvik.HotelManagement.model.HotelRoom;
import com.hritvik.HotelManagement.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    IRoomRepo roomRepo;
    public Iterable<HotelRoom> getAllRooms() {
        return roomRepo.findAll();
    }

    public String addRoom(HotelRoom room) {
        roomRepo.save(room);
        return "Added";

    }
}
