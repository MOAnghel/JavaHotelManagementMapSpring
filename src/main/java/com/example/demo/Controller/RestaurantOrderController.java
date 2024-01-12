package com.example.demo.Controller;

import com.example.demo.Models.RestaurantOrder;
import com.example.demo.Models.request.RestaurantOrderDTO;
import com.example.demo.Repository.JPA.RestaurantOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurantOrder")
public class RestaurantOrderController {
    @Autowired
    RestaurantOrderRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{restaurantOrderId}")
    public Optional<RestaurantOrder> getRestaurantOrderById(@PathVariable Long restaurantOrderId) {
        return repository.findById(restaurantOrderId);
    }

    @GetMapping()
    public List<RestaurantOrder> getAllRestaurantOrders() {
        return repository.findAll();
    }

    @PostMapping()
    public void addRestaurantOrder(@RequestBody RestaurantOrderDTO restaurantOrder) {
        RestaurantOrder mappedRestaurantOrder = mapper.convertValue(restaurantOrder, RestaurantOrder.class);
        repository.save(mappedRestaurantOrder);
    }


    @DeleteMapping("/delete/{restaurantOrderId}")
    public void removeRestaurantOrder(@PathVariable Long restaurantOrderId) {
        RestaurantOrder existingRestaurantOrder = repository.findById(restaurantOrderId)
                .orElseThrow(() -> new RuntimeException("Restaurant order not found with id: " + restaurantOrderId));
        repository.delete(existingRestaurantOrder);
    }

    @PutMapping("/update/{restaurantOrderId}")
    public RestaurantOrder updateRestaurantOrder(@PathVariable Long restaurantOrderId, @RequestBody RestaurantOrderDTO updatedRestaurantOrder) {
        RestaurantOrder existingRestaurantOrder = repository.findById(restaurantOrderId)
                .orElseThrow(() -> new RuntimeException("Restaurant order not found with id: " + restaurantOrderId));
        existingRestaurantOrder.setPaymentMethod(updatedRestaurantOrder.getPaymentMethod());
        return repository.save(existingRestaurantOrder);
    }

    @GetMapping("/printAll")
    public void printAllRestaurantOrders() {
        List<RestaurantOrder> restaurantOrders = repository.findAll();
        restaurantOrders.forEach(restaurantOrder -> System.out.println(restaurantOrder.toString()));
    }
}
