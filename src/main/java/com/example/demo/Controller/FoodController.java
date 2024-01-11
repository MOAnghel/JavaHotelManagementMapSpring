package com.example.demo.Controller;

import com.example.demo.Models.Food;
import com.example.demo.Models.request.FoodDTO;
import com.example.demo.Repository.JPA.FoodRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{foodId}")
    public Optional<Food> getFoodById(@PathVariable Long foodId) {
        return repository.findById(foodId);
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return repository.findAll();
    }

    @PostMapping
    public void addFood(@RequestBody FoodDTO food) {
        Food mappedFood = mapper.convertValue(food, Food.class);
        repository.save(mappedFood);
    }

    @DeleteMapping
    public void removeFood(@RequestBody FoodDTO food) {
        Food mappedFood = mapper.convertValue(food, Food.class);
        repository.delete(mappedFood);
    }

    @GetMapping("/printAll")
    public void printAllFoods() {
        List<Food> foods = repository.findAll();
        foods.forEach(food -> System.out.println(food.toString()));
    }
}
