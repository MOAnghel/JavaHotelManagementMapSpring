package com.example.demo.Service;

import com.example.demo.Models.Person;
import com.example.demo.Repository.InMemory.IRepository;
import com.example.demo.Repository.JPA.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service for extracting Employee repository info
 */


@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class EmployeeService extends PersonService<Person> {

    @Autowired
    PersonRepository personRepository;
}
