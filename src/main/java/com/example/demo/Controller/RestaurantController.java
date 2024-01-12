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
@RequestMapping("/api/restaurant")
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

    @DeleteMapping("/delete/{restaurantId}")
    public void removeRestaurant(@PathVariable Long restaurantId) {
        Restaurant existingRestaurant = repository.findById(restaurantId)
                        .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
        repository.delete(existingRestaurant);
    }

    @PutMapping("/update/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable Long restaurantId, @RequestBody RestaurantDTO updatedRestaurant) {
        Restaurant existingRestaurant = repository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
        existingRestaurant.setName(updatedRestaurant.getName());
        return repository.save(existingRestaurant);
    }

    @GetMapping("/printAll")
    public void printAllRestaurants() {
        List<Restaurant> restaurants = repository.findAll();
        restaurants.forEach(restaurant -> System.out.println(restaurant.toString()));
    }
}
