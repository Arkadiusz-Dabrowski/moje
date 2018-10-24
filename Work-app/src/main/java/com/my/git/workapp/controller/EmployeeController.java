package com.my.git.workapp.controller;

import com.my.git.workapp.exception.NotFoundException;
import com.my.git.workapp.model.Employee;
import com.my.git.workapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/findall")
    public Iterable findAll(){
        return employeeRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Employee findById(@PathVariable("id") Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found by id:" + id));
    }
    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }
}
