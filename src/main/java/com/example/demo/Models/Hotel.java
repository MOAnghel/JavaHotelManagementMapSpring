package com.example.demo.Models;

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
public class Hotel extends BaseEntity{
    @Column
    private String name;

    @Column
    private String address;

    @ManyToMany
    private Set<Employee> hotelEmployees = new HashSet<>();
}
