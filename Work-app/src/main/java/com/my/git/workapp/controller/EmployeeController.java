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
    @GetMapping(value = "/employeelist")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }


    @GetMapping(value = "{id}")
    public EmployeeDto findById(@PathVariable("id") Long id) {
        return employeeMapper.employeeDto(employeeService.getById(id));
    }

    @GetMapping(value = "{email}")
    public EmployeeDto findByEmail(@PathVariable("{email") String email) {
        return employeeMapper.employeeDto(employeeService.getByEmail(email));
    }

    @GetMapping(value = "{firstname}" + "{secondname}")
    public EmployeeDto findByFirstAndSecond(@PathVariable("firstname") String firstName, @PathVariable("secondname") String secondName) {

        return employeeMapper.employeeDto(employeeService.getEmployeeByFirsNameAndSecondName(firstName, secondName));
    }

    @DeleteMapping
    public void delate(Long id) {
        employeeService.delateById(id);
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Employee create(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeMapper.toEmployeeEntity(employeeDto));
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody EmployeeDto newEmployee) {
        try {
            Employee employee = employeeService.getOne(id);
            employee.setFirstName(newEmployee.getFirstName());
            employee.setSecondName(newEmployee.getSecondName());
            employee.setEmail(newEmployee.getEmail());
            employee.setPhoneNumber(newEmployee.getPhoneNumber());
            employee.setGender(newEmployee.getGender());
             employeeService.save(employee);
        } catch (EntityNotFoundException e) {
            e.printStackTrace(System.out.printf("pacownik o podanym id nie istnieje"));
        }

    }
}

