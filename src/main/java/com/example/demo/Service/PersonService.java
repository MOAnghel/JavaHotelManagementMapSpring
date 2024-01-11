package com.example.demo.Service;

import com.example.demo.Models.Person;
import com.example.demo.Repository.InMemory.IRepository;
import com.example.demo.Repository.JPA.PersonRepository;
import org.springframework.stereotype.Service;

/**
 * Service for extracting Person repository info
 */

@Service
public abstract class PersonService<PersonType extends Person> {
    private final PersonRepository repository;


    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
}
