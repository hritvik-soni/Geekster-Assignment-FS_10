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

    /**
     *
     * @return
     */
    public Iterable<HotelRoom> getAllRooms() {
        return roomRepo.findAll();
    }

    /**
     *
     * @param room
     * @return
     */

    public String addRoom(HotelRoom room) {
        roomRepo.save(room);
        return "Added";

    }

    /**
     *
     * @param room
     * @return
     */

    public String addRooms(List<HotelRoom> room) {
        roomRepo.saveAll(room);
        return "Added";
    }

    /**
     *
     * @param roomId
     * @return
     */
    public HotelRoom getAllRoomsById(Long roomId) {
        Optional<HotelRoom> optional= roomRepo.findById(roomId);
        if(optional.isEmpty()){
            return null;
        }
        return optional.get();
    }


}
