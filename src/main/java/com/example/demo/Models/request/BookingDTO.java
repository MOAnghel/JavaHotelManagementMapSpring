package com.example.demo.Models.request;

import com.example.demo.Models.Client;
import com.example.demo.Models.Hotel;
import com.example.demo.Models.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDTO {

    private Client client;

    private Hotel hotel;

    private Set<Room> bookedRooms;
}
