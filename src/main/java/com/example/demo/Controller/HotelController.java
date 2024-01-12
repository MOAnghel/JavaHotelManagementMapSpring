package com.example.demo.Controller;

import com.example.demo.Models.Hotel;
import com.example.demo.Models.request.HotelDTO;
import com.example.demo.Repository.JPA.HotelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    HotelRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{hotelId}")
    public Optional<Hotel> getHotelById(@PathVariable Long hotelId) {
        return repository.findById(hotelId);
    }

    @GetMapping()
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    @PostMapping()
    public void addHotel(@RequestBody HotelDTO hotel) {
        Hotel mappedHotel = mapper.convertValue(hotel, Hotel.class);
        repository.save(mappedHotel);
    }

    @DeleteMapping("/delete/{hotelId}")
    public void removeHotel(@PathVariable Long hotelId) {
        Hotel existingHotel = repository.findById(hotelId)
                        .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));
        repository.delete(existingHotel);
    }

    @PutMapping("/update/{hotelId}")
    public Hotel updateHotel(@PathVariable Long hotelId, @RequestBody HotelDTO updatedHotel) {
        Hotel existingHotel = repository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));
        existingHotel.setName(updatedHotel.getName());
        return repository.save(existingHotel);
    }

    @GetMapping("/printAll")
    public void printAllHotels() {
        List<Hotel> hotels = repository.findAll();
        hotels.forEach(hotel -> System.out.println(hotel.toString()));
    }
}
