package com.example.demo.Models;

import com.example.demo.Service.Observer.IObserverDeletedRoom;
import com.example.demo.Service.Subject.ISubjectDeletedRoom;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for representing hotels
 */

@Entity
@Table(name = "hotel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel extends BaseEntity implements ISubjectDeletedRoom {
    @Column
    private String name;

    @Column
    private String address;

    @ManyToMany
    private Set<Employee> hotelEmployees = new HashSet<>();

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hotelEmployees=" + hotelEmployees +
                ", id=" + id +
                '}';
    }

    @Override
    public void addObserver(IObserverDeletedRoom observer) {}

    @Override
    public void removeObserver(IObserverDeletedRoom observer) {}

    @Override
    public void notifyDeletedRoom(Room room) {
        System.out.println("Hotel" + name + "has received an update");
    }
}
