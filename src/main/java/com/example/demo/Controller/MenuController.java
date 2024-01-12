package com.example.demo.Controller;

import com.example.demo.Models.Menu;
import com.example.demo.Models.request.MenuDTO;
import com.example.demo.Repository.JPA.MenuRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    MenuRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{menuId}")
    public Optional<Menu> getMenuById(@PathVariable Long menuId) {
        return repository.findById(menuId);
    }

    @GetMapping()
    public List<Menu> getAllMenus() {
        return repository.findAll();
    }

    @PostMapping()
    public void addMenu(@RequestBody MenuDTO menu) {
        Menu mappedMenu = mapper.convertValue(menu, Menu.class);
        repository.save(mappedMenu);
    }

    @DeleteMapping("/delete/{menuId}")
    public void removeMenu(@PathVariable Long menuId) {
        Menu existingMenu = repository.findById(menuId)
                        .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));
        repository.delete(existingMenu);
    }

    @PutMapping("/update/{menuId}")
    public Menu updateMenu(@PathVariable Long menuId, @RequestBody MenuDTO updatedMenu) {
        Menu existingMenu = repository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));
        existingMenu.setName(updatedMenu.getName());
        return repository.save(existingMenu);
    }

    @GetMapping("/printAll")
    public void printAllMenus() {
        List<Menu> menus = repository.findAll();
        menus.forEach(menu -> System.out.println(menu.toString()));
    }
}
