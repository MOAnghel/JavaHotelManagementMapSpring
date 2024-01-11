package com.example.demo.Controller;

import com.example.demo.Models.Restaurant;
import com.example.demo.Models.request.RestaurantDTO;
import com.example.demo.Repository.JPA.RestaurantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{restaurantId}")
    public Optional<Restaurant> getRestaurantById(@PathVariable Long restaurantId) {
        return repository.findById(restaurantId);
    }

    @GetMapping()
    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }

    @PostMapping()
    public void addRestaurant(@RequestBody RestaurantDTO restaurant) {
        Restaurant mappedRestaurant = mapper.convertValue(restaurant, Restaurant.class);
        repository.save(mappedRestaurant);
    }

    @DeleteMapping()
    public void removeRestaurant(@RequestBody RestaurantDTO restaurant) {
        Restaurant mappedRestaurant = mapper.convertValue(restaurant, Restaurant.class);
        repository.delete(mappedRestaurant);
    }

    @GetMapping("/printAll")
    public void printAllRestaurants() {
        List<Restaurant> restaurants = repository.findAll();
        restaurants.forEach(restaurant -> System.out.println(restaurant.toString()));
    }
}
