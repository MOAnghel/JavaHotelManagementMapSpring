package com.example.demo.Controller;

import com.example.demo.Models.Person;
import com.example.demo.Models.request.PersonDTO;
import com.example.demo.Repository.JPA.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{personId}")
    public Optional<Person> getPersonById(@PathVariable Long personId) {
        return repository.findById(personId);
    }

    @GetMapping()
    public void addPerson(@RequestBody PersonDTO person) {
        Person mappedPerson = mapper.convertValue(person, Person.class);
        repository.save(mappedPerson);
    }

    @DeleteMapping()
    public void removePerson(@RequestBody PersonDTO person) {
        Person mappedPerson = mapper.convertValue(person, Person.class);
        repository.delete(mappedPerson);
    }

    @GetMapping("/printAll")
    public void printAllPersons() {
        List<Person> persons = repository.findAll();
        persons.forEach(person -> System.out.println(person.toString()));
    }
}
