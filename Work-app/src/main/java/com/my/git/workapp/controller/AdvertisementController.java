package com.my.git.workapp.controller;


import com.my.git.workapp.dto.AdvertisementDto;
import com.my.git.workapp.dto.EmployerWithAdvertsDto;
import com.my.git.workapp.mapper.AdvertisementMapper;
import com.my.git.workapp.mapper.EmployerMapper;
import com.my.git.workapp.model.Advertisement;
import com.my.git.workapp.model.Employer;
import com.my.git.workapp.service.AdvertisementService;
import com.my.git.workapp.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "advertisement")
public class AdvertisementController {

    @Autowired
    AdvertisementMapper mapper;

    @Autowired
    EmployerMapper employerMapper;

    @Autowired
    EmployerService employerService;


    @Autowired
    AdvertisementService advertisementService;


    @GetMapping(value = "/all")
    @ResponseBody
    public List<AdvertisementDto> showList(@RequestParam(defaultValue="title")String orderBy) {//TODO change to RequestParam
        List<Advertisement> advertisements = advertisementService.getAdvertisementList();
        return advertisements.stream().map(advertisement -> mapper.toAdvertisementDto(advertisement)).collect(Collectors.toList());
    }

    @GetMapping(value = "/id/{id}")
    public AdvertisementDto getById(@PathVariable("id") Long id) {
        return   mapper.toAdvertisementDto(advertisementService.getAdvertisementById(id));
    }

    @GetMapping(value = "/company/{company}")
    public List<AdvertisementDto> getByEmployer(@PathVariable("company") String companyName) {
        return mapper.toAdvertisementDto(advertisementService.getAdvertismentbyEmployerCN(companyName));

    }

    @PostMapping(value = "/create/employer/{employer_id}")
    public EmployerWithAdvertsDto employerToAdvertisement(@PathVariable("employer_id") Long employer_Id, @RequestBody AdvertisementDto advertisementDto) {
        Employer employer = employerService.getOne(employer_Id);
        employer.addAdvertisement(mapper.toAdvertisementEntity(advertisementDto));
        Employer savedEmployer = employerService.save(employer);
        return employerMapper.toEmplyerWithAdvertsDto(savedEmployer);
    }
    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, @RequestBody AdvertisementDto newAdvertisement){
        advertisementService.update(newAdvertisement,id);
    }


    @DeleteMapping(value = "/delatebyid/{id}")
    public void delateById(@PathVariable(value = "id") Long id) {
        advertisementService.delateAdvertisement(id);
    }



    }

