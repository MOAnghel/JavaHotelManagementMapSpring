package com.example.demo.Controller;

import com.example.demo.Models.Room;
import com.example.demo.Models.request.RoomDTO;
import com.example.demo.Repository.JPA.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    RoomRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{roomId}")
    public Optional<Room> getRoomById(@PathVariable Long roomId) {
        return repository.findById(roomId);
    }

    @GetMapping()
    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    @PostMapping()
    public void addRoom(@RequestBody RoomDTO room) {
        Room mappedRoom = mapper.convertValue(room, Room.class);
        repository.save(mappedRoom);
    }

    @DeleteMapping()
    public void removeRoom(@RequestBody RoomDTO room) {
        Room mappedRoom = mapper.convertValue(room, Room.class);
        repository.delete(mappedRoom);
    }

    @GetMapping("/printAll")
    public void printAllRooms() {
        List<Room> rooms = repository.findAll();
        rooms.forEach(room -> System.out.println(room.toString()));
    }
}
