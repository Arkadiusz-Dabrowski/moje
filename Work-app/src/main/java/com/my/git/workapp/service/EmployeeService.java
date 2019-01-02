package com.my.git.workapp.service;

import com.my.git.workapp.exception.NotFoundException;
import com.my.git.workapp.model.Employee;
import com.my.git.workapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public void setEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found by id:" + id));
    }

    public Employee getByEmail(String email) {
        return employeeRepository.getEmployeeByEmail(email);
    }

    public Employee getEmployeeByFirsNameAndSecondName(String firstName, String secondName) {
        return employeeRepository.getEmployeeByFirstNameAndSecondName(firstName, secondName);
    }

    public Boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }

    public Employee getOne(Long id) {
        return employeeRepository.getOne(id);
    }


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void delateByEmail(String email) {
        employeeRepository.deleteByEmail(email);
    }

    public void delateById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Employee newEmployee, Long id) {
        try {
            Employee employee = getOne(id);
            employee.setFirstName(newEmployee.getFirstName());
            employee.setSecondName(newEmployee.getSecondName());
            employee.setEmail(newEmployee.getEmail());
            employee.setPhoneNumber(newEmployee.getPhoneNumber());
            employee.setGender(newEmployee.getGender());
            save(employee);
        } catch (EntityNotFoundException e) {
            e.printStackTrace(System.out.printf("pacownik o podanym id nie istnieje"));
        }
        return newEmployee;
    }
}


