package com.my.git.workapp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "Employee")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    @GetMapping("findall")
    public Iterable findAll(){
        return employeeRepository.findAll();
    }
    @GetMapping("byID/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found by id:" + id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }
}
