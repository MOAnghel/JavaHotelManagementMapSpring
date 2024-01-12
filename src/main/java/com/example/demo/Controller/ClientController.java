package com.example.demo.Controller;

import com.example.demo.Models.Client;
import com.example.demo.Models.request.ClientDTO;
import com.example.demo.Repository.JPA.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{clientId}")
    public Optional<Client> getClientById(@PathVariable Long clientId) {
        return repository.findById(clientId);
    }

    @GetMapping()
    public List<Client> getAllClients() {
        return repository.findAll();
    }

    @PostMapping()
    public void addClient(@RequestBody ClientDTO client) {
        Client mappedClient = mapper.convertValue(client, Client.class);
        repository.save(mappedClient);
    }

    @DeleteMapping()
    public void removeClient(@RequestBody ClientDTO client) {
        Client mappedClient = mapper.convertValue(client, Client.class);
        repository.delete(mappedClient);
    }

    @GetMapping("/printAll")
    public void printAllClients() {
        List<Client> clients = repository.findAll();
        clients.forEach(client -> System.out.println(client.toString()));
    }
}
