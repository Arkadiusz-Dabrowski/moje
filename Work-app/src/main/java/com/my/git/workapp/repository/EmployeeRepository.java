package com.my.git.workapp.repository;

import com.my.git.workapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee getEmployeeByFirstNameAndSecondName(String firstName, String secondName);
    public Employee getEmployeeByEmail(String email);
    public void deleteByEmail(String email);
}
