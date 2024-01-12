package com.example.demo.Models;

import com.example.demo.Service.Observer.IObserverDeletedItem;
import com.example.demo.Service.Subject.ISubjectDeletedItem;
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
public class Menu extends BaseEntity implements ISubjectDeletedItem {
    @Column
    private String name;

    @JsonIgnore
    @OneToMany
    private Set<Item> items = new HashSet<>();

    @ManyToMany
    private Set<Restaurant> restaurantsMenus = new HashSet<>();

    @Override
    public void addObserver(IObserverDeletedItem observer) {}

    @Override
    public void removeObserver(IObserverDeletedItem observer) {}

    @Override
    public void notifyDeletedItem(Item item) {
        System.out.println("Menu " + name + "has received an update");
    }
}
