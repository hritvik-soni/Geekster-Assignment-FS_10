package com.hritvik.HotelManagement.service;

import com.hritvik.HotelManagement.model.HotelRoom;
import com.hritvik.HotelManagement.repository.IRoomRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    @Mock
    private IRoomRepo roomRepo;

    @InjectMocks
    private RoomService roomService;

    @Test
    public void testGetAllRoomsWhenRoomsExistThenReturnRooms() {
        List<HotelRoom> rooms = Arrays.asList(new HotelRoom(), new HotelRoom());
        when(roomRepo.findAll()).thenReturn(rooms);

        Iterable<HotelRoom> result = roomService.getAllRooms();

        assertThat(result).isEqualTo(rooms);
    }

    @Test
    public void testGetAllRoomsWhenNoRoomsExistThenReturnEmptyList() {
        when(roomRepo.findAll()).thenReturn(Arrays.asList());

        Iterable<HotelRoom> result = roomService.getAllRooms();

        assertThat(result).isEmpty();
    }

    @Test
    public void testAddRoom() {
        HotelRoom room = new HotelRoom();
        when(roomRepo.save(room)).thenReturn(room);

        String result = roomService.addRoom(room);

        assertThat(result).isEqualTo("Added");
        verify(roomRepo, times(1)).save(room);
    }

    @Test
    public void testAddRooms() {
        List<HotelRoom> rooms = Arrays.asList(new HotelRoom(), new HotelRoom());
        when(roomRepo.saveAll(rooms)).thenReturn(rooms);

        String result = roomService.addRooms(rooms);

        assertThat(result).isEqualTo("Added");
        verify(roomRepo, times(1)).saveAll(rooms);
    }

    @Test
    public void testGetAllRoomsByIdWhenRoomExistsThenReturnRoom() {
        HotelRoom room = new HotelRoom();
        room.setRoomId(1L);
        when(roomRepo.findById(1L)).thenReturn(Optional.of(room));

        HotelRoom result = roomService.getAllRoomsById(1L);

        assertThat(result).isEqualTo(room);
    }

    @Test
    public void testGetAllRoomsByIdWhenRoomDoesNotExistThenReturnNull() {
        when(roomRepo.findById(1L)).thenReturn(Optional.empty());

        HotelRoom result = roomService.getAllRoomsById(1L);

        assertThat(result).isNull();
    }
}
