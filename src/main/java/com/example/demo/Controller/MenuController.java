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
@RequestMapping("/controller")
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

    @DeleteMapping()
    public void removeMenu(@RequestBody MenuDTO menu) {
        Menu mappedMenu = mapper.convertValue(menu, Menu.class);
        repository.delete(mappedMenu);
    }

    @GetMapping("/printAll")
    public void printAllMenus() {
        List<Menu> menus = repository.findAll();
        menus.forEach(menu -> System.out.println(menu.toString()));
    }
}
