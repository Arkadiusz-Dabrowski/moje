package com.my.git.workapp.controller;

import com.my.git.workapp.exception.NotFoundException;
import com.my.git.workapp.model.Advertisement;
import com.my.git.workapp.model.Employer;
import com.my.git.workapp.repository.AdvertisementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/advertisement")
public class AdvertisementController {

    AdvertisementRepository advertisementRepository;
    Employer employer = new Employer();

    @GetMapping
    Iterable<Advertisement> showList(){
        return advertisementRepository.findAll();
    }
    @GetMapping("id/{id}")
    Advertisement selectById(@PathVariable("id") Long id){
        return advertisementRepository.findById(id).orElseThrow(()-> new NotFoundException("Advetrisement not found"));
    }

    @PostMapping("/employer/{id}/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Advertisement create(@PathVariable(value = "id")Long advertisement_id, @Valid @RequestBody Advertisement advertisement){
        Advertisement advertisement1 = advertisementRepository.save(advertisement);
        return advertisement1;
    }
    @PutMapping(value = "delatebyid/{id}")
    public void delateById(@PathVariable(value = "id") Long advertiement_id){
         advertisementRepository.deleteById(advertiement_id);
    }
}
