package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class representing employees of a specific hotel
 */

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee extends Person{
    @Column
    protected Double salary;

    @JsonIgnore
    @ManyToMany
    private Set<Hotel> hotelEmployees = new HashSet<>();

    public Employee(String name, String email, String phoneNumber, Double salary) {
        super(name, email, phoneNumber);
        this.salary = salary;
    }

    public Employee copy() {
        return new Employee(name, email, phoneNumber, salary);
    }
}
