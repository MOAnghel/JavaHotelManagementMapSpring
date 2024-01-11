package com.example.demo.Service;

import com.example.demo.Models.Person;
import com.example.demo.Repository.JPA.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for extracting Employee repository info
 */


@Service
public class EmployeeService extends PersonService<Person> {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
}
