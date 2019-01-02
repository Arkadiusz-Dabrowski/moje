package com.my.git.workapp.controller.web;

import com.my.git.workapp.dto.EmployeeDto;
import com.my.git.workapp.mapper.EmployeeMapper;
import com.my.git.workapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeMvcController {
    private EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeMvcController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getAllEmployees(Model model) {
        List<EmployeeDto> employees = employeeMapper.employeeDto(employeeService.getEmployees());
        model.addAttribute("employeeList",employees);
        return "employee-list";

    }


}
