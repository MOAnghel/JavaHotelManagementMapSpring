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
@RequestMapping("/hotel")
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

    @DeleteMapping()
    public void removeHotel(@RequestBody HotelDTO hotel) {
        Hotel mappedHotel = mapper.convertValue(hotel, Hotel.class);
        repository.delete(mappedHotel);
    }
}
