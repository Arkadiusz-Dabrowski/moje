package com.my.git.workapp.controller;

import com.my.git.workapp.exception.NotFoundException;
import com.my.git.workapp.model.Employer;
import com.my.git.workapp.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "employer")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    EmployerMapper mapper;

    @GetMapping(value = "/all")
    public List<EmployerDto> findAll() {
        return mapper.toEmployerDto(employerService.findAll());
    }

    @GetMapping(value = "{id}")
    public EmployerDto findById(@PathVariable("id") Long id) {
        return mapper.toEmployerDto(employerService.findById(id));
    }
    @GetMapping(value = "/{companyName}")
    public EmployerDto findByCompanyName(@PathVariable("companyName")String companyName){
        return mapper.toEmployerDto(employerService.getbycompanyName(companyName));
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employer create(@RequestBody EmployerDto employerDto) {
        return employerService.create(mapper.toEmployerEntity(employerDto));

    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody EmployerDto newEmployer) {
        try {
            Employer employer = employerService.getOne(id);
            employer.setCompanyName(newEmployer.getCompanyName());
            employer.setEmail(newEmployer.getEmail());
            employer.setPhoneNumber(newEmployer.getPhoneNumber());


            employerService.create(employer);
        } catch(EntityNotFoundException e){
            e.printStackTrace(System.out.printf("Pracodawca o podanym id nie istnieje"));
        }
    }
    @DeleteMapping
    public void delate(Long id){
        employerService.delateByID(id);
    }


}
