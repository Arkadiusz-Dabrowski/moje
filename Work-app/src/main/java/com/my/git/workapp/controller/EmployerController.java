package com.my.git.workapp.controller;

import com.my.git.workapp.dto.EmployerDto;
import com.my.git.workapp.mapper.EmployerMapper;
import com.my.git.workapp.model.Employer;
import com.my.git.workapp.service.AdvertisementService;
import com.my.git.workapp.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "employer")
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    EmployerMapper mapper;

    @GetMapping(value = "/all")
    public List<EmployerDto> showList() {
        return mapper.toEmployerDto(employerService.findAll());
    }

    @GetMapping(value = "/id/{id}")
    public EmployerDto getById(@PathVariable("id") Long id) {
        return mapper.toEmployerDto(employerService.findById(id));
    }

    @GetMapping(value = "/companyname/{companyName}")
    public EmployerDto getByCompanyName(@PathVariable("companyName")String companyName){//TODO change to request param
        return mapper.toEmployerDto(employerService.getByCompanyName(companyName));
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employer create(@RequestBody EmployerDto employerDto) {
        return employerService.save(mapper.toEmployerEntity(employerDto));

    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody EmployerDto newEmployer) {
      employerService.update(newEmployer);
    }
    @DeleteMapping(value = "/delatebyid")
    public void delateById(Long id){
        employerService.delateByID(id);
    }


}
