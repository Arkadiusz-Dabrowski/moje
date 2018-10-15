package com.my.git.workapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "employer")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping(value = "/all")
    public Iterable findAll(){
        return employerRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Employer findById(@PathVariable("id") Long id){
        return employerRepository.findById(id).orElseThrow(() -> new EmployerNotFoundException("Employer not found"));
    }
    @PostMapping(value = "create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employer save(@RequestBody Employer employer){
        Employer employer1 = employerRepository.save(employer);
        return employer1;
    }
}
