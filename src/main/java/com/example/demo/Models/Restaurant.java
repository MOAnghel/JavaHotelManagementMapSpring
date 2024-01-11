package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity for representing restaurants
 */

@Entity
@Table(name = "restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant extends BaseEntity{
    @Column
    private String name;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "restaurantID")
    //private Set<Menu> menus = new HashSet<>();

    //
    @JsonIgnore
    @ManyToMany
    private Set<Menu> restaurantMenus = new HashSet<>();

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", restaurantMenus=" + restaurantMenus +
                ", id=" + id +
                '}';
    }
}
