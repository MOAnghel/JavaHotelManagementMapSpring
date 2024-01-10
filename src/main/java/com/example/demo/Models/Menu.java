package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for representing a restaurant menu
 */

@Entity
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu extends BaseEntity{
    @Column
    private String name;

    @JsonIgnore
    @OneToMany
    private Set<Item> items = new HashSet<>();

    @ManyToMany
    private Set<Restaurant> restaurantsMenus = new HashSet<>();
}
