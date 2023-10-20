package com.hritvik.HotelManagement.controller;

import com.hritvik.HotelManagement.model.HotelRoom;
import com.hritvik.HotelManagement.model.Type;
import com.hritvik.HotelManagement.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    private List<HotelRoom> roomList;

    @BeforeEach
    void setUp() {
        this.roomList = Arrays.asList(
                new HotelRoom(1L, 101, Type.AC, 1000.0, true),
                new HotelRoom(2L, 102, Type.NON_AC, 800.0, true)
        );
    }

    @Test
    public void testGetAllRoomsWhenRoomsPresentThenReturnRooms() throws Exception {
        when(roomService.getAllRooms()).thenReturn(roomList);

        mockMvc.perform(get("/rooms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].roomId").value(roomList.get(0).getRoomId()));
    }

    @Test
    public void testGetRoomByIdWhenValidIdThenReturnRoom() throws Exception {
        Long roomId = 3L;
        HotelRoom room = new HotelRoom(roomId, 101, Type.AC, 1000.0, true);

        when(roomService.getAllRoomsById(roomId)).thenReturn(room);

        mockMvc.perform(get("/rooms/search/{roomId}", roomId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roomId").value(roomId));
    }

    @Test
    public void testAddRoomWhenValidRoomThenReturnSuccess() throws Exception {
        HotelRoom room = new HotelRoom(1L, 101, Type.AC, 1000.0, true);
        when(roomService.addRoom(room)).thenReturn("Added");

        mockMvc.perform(post("/room")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"roomId\":1,\"roomNumber\":101,\"roomType\":\"AC\",\"roomPrice\":1000.0,\"roomStatus\":true}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Added"));
    }

    @Test
    public void testAddRoomsWhenValidRoomsThenReturnSuccess() throws Exception {
        when(roomService.addRooms(roomList)).thenReturn("Added");

        mockMvc.perform(post("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[{\"roomId\":1,\"roomNumber\":101,\"roomType\":\"AC\",\"roomPrice\":1000.0,\"roomStatus\":true}," +
                        "{\"roomId\":2,\"roomNumber\":102,\"roomType\":\"NON_AC\",\"roomPrice\":800.0,\"roomStatus\":true}]"))
                .andExpect(status().isOk())
                .andExpect(content().string("Added"));
    }
}
