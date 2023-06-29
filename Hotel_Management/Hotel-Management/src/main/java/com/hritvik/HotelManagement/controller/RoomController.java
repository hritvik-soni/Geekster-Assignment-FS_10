package com.hritvik.HotelManagement.controller;


import com.hritvik.HotelManagement.model.HotelRoom;
import com.hritvik.HotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("rooms")
    public Iterable<HotelRoom> getAllRooms()
    {
        return roomService.getAllRooms();
    }
    @GetMapping("rooms/search/{roomID}")
    public HotelRoom getRoomById(@PathVariable Long roomId)
    {
        return roomService.getAllRoomsById(roomId);
    }

    @PostMapping("room")
    public String addRoom(@RequestBody HotelRoom room)
    {
        return roomService.addRoom(room);
    }

    @PostMapping("rooms")
    public String addRooms(@RequestBody List<HotelRoom> room)
    {
        return roomService.addRooms(room);
    }



}
