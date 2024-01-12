package com.example.demo.Controller;

import com.example.demo.Models.Item;
import com.example.demo.Models.request.ItemDTO;
import com.example.demo.Repository.JPA.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    ItemRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{itemId}")
    public Optional<Item> getItemById(@PathVariable Long itemId) {
        return repository.findById(itemId);
    }

    @GetMapping()
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @PostMapping()
    public void addItem(@RequestBody ItemDTO item) {
        Item mappedItem = mapper.convertValue(item, Item.class);
        repository.save(mappedItem);
    }

    @DeleteMapping("/delete/{itemId}")
    public void removeItem(@PathVariable Long itemId) {
        Item existingItem = repository.findById(itemId)
                        .orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));
        repository.delete(existingItem);
    }

    @PutMapping("/update/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody ItemDTO updatedItem) {
        Item existingItem = repository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));
        existingItem.setName(updatedItem.getName());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setDescription(updatedItem.getDescription());
        return repository.save(existingItem);
    }

    @GetMapping("/printAll")
    public void printAllItems() {
        List<Item> items = repository.findAll();
        items.forEach(item -> System.out.println(item.toString()));
    }
}
