package com.example.demo.Controller;

import com.example.demo.Models.Beverage;
import com.example.demo.Models.request.BeverageDTO;
import com.example.demo.Repository.JPA.BeverageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/beverage")
public class  BeverageController {
    @Autowired
    BeverageRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{beverageId}")
    public Optional<Beverage> getBeverageById(@PathVariable Long beverageId) {
        return repository.findById(beverageId);
    }

    @GetMapping()
    public List<Beverage> getAllBeverages() {
        return repository.findAll();
    }

    @PostMapping()
    public void addBeverage(@RequestBody BeverageDTO beverage) {
        Beverage mappedBeverage = mapper.convertValue(beverage, Beverage.class);
        repository.save(mappedBeverage);
    }

    @DeleteMapping()
    public void removeBeverage(@RequestBody BeverageDTO beverage) {
        Beverage mappedBeverage = mapper.convertValue(beverage, Beverage.class);
        repository.delete(mappedBeverage);
    }
}
