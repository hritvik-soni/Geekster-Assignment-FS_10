package com.hritvik.HotelManagement.service;

import com.hritvik.HotelManagement.model.HotelRoom;
import com.hritvik.HotelManagement.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String addRooms(List<HotelRoom> room) {
        roomRepo.saveAll(room);
        return "Added";
    }

    public HotelRoom getAllRoomsById(Long roomId) {
        Optional<HotelRoom> optional= roomRepo.findById(roomId);
        return optional.get();
    }


}
