package com.example.demo.Controller;

import com.example.demo.Models.Employee;
import com.example.demo.Models.request.EmployeeDTO;
import com.example.demo.Repository.JPA.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository repository;

    @Autowired
    ObjectMapper mapper;
    @GetMapping(value = "/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return repository.findById(employeeId);
    }

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @PostMapping()
    public void addEmployee(@RequestBody EmployeeDTO employee) {
        Employee mappedEmployee = mapper.convertValue(employee, Employee.class);
        repository.save(mappedEmployee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void removeEmployee(@PathVariable Long employeeId) {
        Employee existingEmployee = repository.findById(employeeId)
                        .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        repository.delete(existingEmployee);
    }

    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO updatedEmployee) {
        Employee existingEmployee = repository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        existingEmployee.setSalary(updatedEmployee.getSalary());
        return repository.save(existingEmployee);
    }

    @GetMapping("/printAll")
    public void printAllEmployees() {
        List<Employee> employees = repository.findAll();
        employees.forEach(employee -> System.out.println(employee.toString()));
    }
}
