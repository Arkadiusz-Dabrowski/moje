package com.my.git.workapp.controller;

import com.my.git.workapp.dto.EmployeeDto;
import com.my.git.workapp.mapper.EmployeeMapper;
import com.my.git.workapp.model.Employee;
import com.my.git.workapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDto>> getEmployees(@RequestParam(defaultValue="firstName") String orderBy) {
        List<EmployeeDto> employeeDtoList = employeeMapper.employeeDto(employeeService.getEmployees());
        return ResponseEntity.ok(employeeDtoList);

    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeMapper.employeeDto(employeeService.getOne(id));
        return ResponseEntity.ok(employeeDto);
    }


    @GetMapping(value = "/email/{email}")
    public ResponseEntity<EmployeeDto> getByEmail(@PathVariable("email") String email) {
        EmployeeDto employeeDto = employeeMapper.employeeDto(employeeService.getByEmail(email));
        return ResponseEntity.ok(employeeDto);
    }


    @GetMapping(value = "{firstname}" + "{secondname}")
    public ResponseEntity<EmployeeDto> getByFirstAndSecond(@PathVariable("firstname") String firstName, @PathVariable("secondname") String secondName) {
        EmployeeDto employeeDto = employeeMapper.employeeDto(employeeService.getEmployeeByFirsNameAndSecondName(firstName, secondName));
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping
    public void delate(Long id) {
        employeeService.delateById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> create(@RequestBody EmployeeDto employeeDto) {
        Employee save = employeeService.save(employeeMapper.toEmployeeEntity(employeeDto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getEmployee_id())
                .toUri();
        return ResponseEntity.created(location).body(save);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody EmployeeDto newEmployee) {
        employeeService.update(employeeMapper.toEmployeeEntity(newEmployee),id);


    }
}

