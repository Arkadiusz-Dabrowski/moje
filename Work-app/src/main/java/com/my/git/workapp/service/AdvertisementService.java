package com.my.git.workapp.service;

import com.my.git.workapp.RegionEnum;
import com.my.git.workapp.dto.AdvertisementDto;
import com.my.git.workapp.model.Advertisement;
import com.my.git.workapp.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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


    public List<Advertisement> getAdvertisementList() {
        return advertisementRepository.findAll();
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

    public void update(AdvertisementDto newAdvertisement, Long id){
        try {
            Advertisement advertisement = getAdvertisementById(newAdvertisement.getId());
            advertisement.setCategory(newAdvertisement.getCategory());
            advertisement.setExpirationDate(newAdvertisement.getExpirationDate());
            advertisement.setRegion(newAdvertisement.getRegion());
            advertisement.setTitle(newAdvertisement.getTitle());
            createAdvertisement(advertisement);
        }
        catch(EntityNotFoundException e){
            e.printStackTrace(System.out.printf("Ogłoszenie o podanym id nie istnieje"));
        }

    }
}





