package com.example.demo.Controller;

import com.example.demo.Models.Booking;
import com.example.demo.Models.request.BookingDTO;
import com.example.demo.Repository.JPA.BookingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable Long bookingId) {
        return repository.findById(bookingId);
    }

    @GetMapping()
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    @PostMapping
    public void addBooking(@RequestBody BookingDTO booking) {
        Booking mappedBooking = mapper.convertValue(booking, Booking.class);
        repository.save(mappedBooking);
    }

    @DeleteMapping
    public void deleteBooking(@RequestBody BookingDTO booking) {
        Booking mappedBooking = mapper.convertValue(booking, Booking.class);
        repository.delete(mappedBooking);
    }

    @GetMapping("/printAll")
    public void printAllBookings() {
        List<Booking> bookings = repository.findAll();
        bookings.forEach(booking -> System.out.println(booking.toString()));
    }
}
