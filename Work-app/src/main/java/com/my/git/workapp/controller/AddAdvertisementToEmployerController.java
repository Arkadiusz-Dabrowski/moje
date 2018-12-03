package com.my.git.workapp.controller;

import com.my.git.workapp.model.Advertisement;
import com.my.git.workapp.model.Employer;
import com.my.git.workapp.service.AdvertisementService;
import com.my.git.workapp.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller(value = "add")
public class AddAdvertisementToEmployerController {

    @Autowired
    EmployerService employerService;

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    Employer employer;



    @PostMapping(value = "/add/{employer_id}/{advertisement_id}")
    public void addAdvertisementToEmployer(@PathVariable("employer_id") Long employerId,@PathVariable("advertisement_id") Long advertisementId){

        employer = employerService.getOne(employerId);
        List<Advertisement> advertisements = Arrays.asList(advertisementService.getAdvertisementById(advertisementId));
        employer.setAdvertisement(advertisements);
        employerService.create(employer);
    }
}
