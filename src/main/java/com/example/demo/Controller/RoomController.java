package com.example.demo.Controller;

import com.example.demo.Models.Hotel;
import com.example.demo.Models.LoggingRoomDecorator;
import com.example.demo.Models.Room;
import com.example.demo.Models.request.RoomDTO;
import com.example.demo.Repository.JPA.HotelRepository;
import com.example.demo.Repository.JPA.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    RoomRepository repository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{roomId}")
    public Optional<Room> getRoomById(@PathVariable Long roomId) {
        return repository.findById(roomId);
    }

    @GetMapping(value = "/getRoomNumber/{roomId}")
    public String getRoomNumber(@PathVariable Long roomId) {
        Room room = repository.findById(roomId).orElse(null);
        if(room != null) {
            LoggingRoomDecorator loggingRoom = new LoggingRoomDecorator(room);
            Integer roomNumber = loggingRoom.getRoomNumber();
            return "Room number: " + roomNumber;
        }
        return null;
    }

    @GetMapping()
    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    @PostMapping()
    public void addRoom(@RequestBody RoomDTO room) {
        Room mappedRoom = mapper.convertValue(room, Room.class);
        Hotel mappedHotel = mapper.convertValue(room.getHotel(), Hotel.class);
        List<Hotel> storedHotels = hotelRepository.findAll();
        for (Hotel hotel: storedHotels) {
            if(Objects.equals(hotel.getName(), mappedHotel.getName())){
                mappedRoom.setHotel(mappedHotel);
            }
        }
        repository.save(mappedRoom);
    }

    @DeleteMapping("/delete/{roomId}")
    public void removeRoom(@PathVariable Long roomId) {
        Room existingRoom = repository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));
        repository.delete(existingRoom);
    }

    @PutMapping("/update/{roomId}")
    public Room updateRoom(@PathVariable Long roomId, @RequestBody RoomDTO updatedRoom) {
        Room existingRoom = repository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));
        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setPrice(updatedRoom.getPrice());
        existingRoom.setNumberOfBeds(updatedRoom.getNumberOfBeds());
        existingRoom.setRoomCategory(updatedRoom.getRoomCategory());
        existingRoom.setOccupied(updatedRoom.isOccupied());
        return repository.save(existingRoom);
    }

    @GetMapping("/printAll")
    public void printAllRooms() {
        List<Room> rooms = repository.findAll();
        rooms.forEach(room -> System.out.println(room.toString()));
    }
}
