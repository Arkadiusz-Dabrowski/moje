package com.my.git.workapp.service;

import com.my.git.workapp.RegionEnum;
import com.my.git.workapp.model.Advertisement;
import com.my.git.workapp.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    AdvertisementRepository advertisementRepository;
    EmployerService employerService;

    public List<Advertisement> getAdvertismentbyEmployerCN(String companyName) {

        List<Advertisement> advertisements = advertisementRepository.getByEmployer(employerService.getByCompanyName(companyName));
        return advertisements;
    }

    public Advertisement getAdvertisementById(Long id) {

        Advertisement advertisement = advertisementRepository.getOne(id);
        return advertisement;

    }
    public Advertisement getAdvertisamentByTitle(String title){
        return advertisementRepository.getAdvertisementByTitle(title);
    }


    public List<Advertisement> getAdvertisementList(String sort) {
        return advertisementRepository.findAll(Sort.by(sort));
    }
    public List<Advertisement> getAdvertisementListByRegion(RegionEnum regionEnum){
        return advertisementRepository.getAdvertisementByRegion(regionEnum);
    }

    public void delateAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }


    public Advertisement createAdvertisement(Advertisement advertisement) {
      return  advertisementRepository.save(advertisement);

    }
}





