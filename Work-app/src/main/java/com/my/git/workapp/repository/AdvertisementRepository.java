package com.my.git.workapp.repository;

import com.my.git.workapp.RegionEnum;
import com.my.git.workapp.model.Advertisement;
import com.my.git.workapp.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {

    public List<Advertisement> getByEmployer(Employer employer);

    public Advertisement getAdvertisementByTitle(String title);

    public List<Advertisement> getAdvertisementByRegion(RegionEnum regionEnum);

    public void deleteByTitle(String title);
}
