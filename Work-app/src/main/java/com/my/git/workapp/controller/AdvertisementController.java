package com.my.git.workapp.controller;


import com.my.git.workapp.dto.AdvertisementDto;
import com.my.git.workapp.mapper.AdvertisementMapper;
import com.my.git.workapp.model.Advertisement;
import com.my.git.workapp.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "advertisement")
public class AdvertisementController {

    @Autowired
    AdvertisementMapper mapper;


    @Autowired
    AdvertisementService advertisementService;


    @GetMapping(value = "/all/{sort}")
    @ResponseBody
    public List<AdvertisementDto> showList(@PathVariable("sort") String sort) {
        List<Advertisement> advertisements = advertisementService.getAdvertisementList(sort);
        return advertisements.stream().map(advertisement -> mapper.toAdvertisementDto(advertisement)).collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    public AdvertisementDto getById(@PathVariable("id") Long id) {
        return   mapper.toAdvertisementDto(advertisementService.getAdvertisementById(id));
    }

    @GetMapping(value = "{company}")
    public List<AdvertisementDto> getByEmployer(@PathVariable("company") String companyName) {
        return mapper.toAdvertisementDto(advertisementService.getAdvertismentbyEmployerCN(companyName));

    }

    @PostMapping(value ="/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Advertisement create (@RequestBody AdvertisementDto advertisementDto) {
        return advertisementService.createAdvertisement(mapper.toAdvertisementEntity(advertisementDto));
    }

    @PutMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, @RequestBody AdvertisementDto advertisementDto){
        try {
            Advertisement advertisement = advertisementService.getAdvertisementById(id);
            advertisement.setCategory(advertisementDto.getCategory());
            advertisement.setExpirationDate(advertisementDto.getExpirationDate());
            advertisement.setRegion(advertisementDto.getRegion());
            advertisement.setTitle(advertisementDto.getTitle());
            advertisementService.createAdvertisement(advertisement);
        }
        catch(EntityNotFoundException e){
            e.printStackTrace(System.out.printf("Ogłoszenie o podanym id nie istnieje"));
        }
    }


    @DeleteMapping(value = "delatebyid/{title}")
    public void delateById(@PathVariable(value = "id") Long id) {
        advertisementService.delateAdvertisement(id);
    }



    }

