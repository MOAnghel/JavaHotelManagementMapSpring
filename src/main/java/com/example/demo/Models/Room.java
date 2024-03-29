package com.example.demo.Models;

import com.example.demo.Models.Enums.RoomCategory;
import com.example.demo.Service.Observer.IObserverDeletedClient;
import com.example.demo.Service.Subject.ISubjectDeletedClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity for representing rooms in a hotel
 */

@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room extends BaseEntity implements IRoom, ISubjectDeletedClient {
    @Column
    private Integer roomNumber;

    @Column
    @Enumerated
    private RoomCategory roomCategory;

    @Column
    private Integer numberOfBeds;

    @Column
    private boolean occupied;

    @Column
    private Integer price;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookedRooms")
    private Set<Booking> bookedRooms = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomCategory=" + roomCategory +
                ", numberOfBeds=" + numberOfBeds +
                ", occupied=" + occupied +
                ", price=" + price +
                ", bookedRooms=" + bookedRooms +
                ", hotel=" + hotel +
                ", id=" + id +
                '}';
    }

    @Override
    public Integer getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void addObserver(IObserverDeletedClient observer) {}

    @Override
    public void removeObserver(IObserverDeletedClient observer) {}

    @Override
    public void notifyDeletedClient(Client client) {
        System.out.println("Room" + roomNumber + "has received an update");
    }
}
