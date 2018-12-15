package com.my.git.workapp.controller;

import com.my.git.workapp.dto.EmployeeDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class RegistrationController {
    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employee", employeeDto);
        return "registration";
    }
   /* public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid EmployeeDto accountDto,
            BindingResult result, WebRequest request, Errors errors) {
    return ModelAndView.class.getClasses();
    }*/
}
