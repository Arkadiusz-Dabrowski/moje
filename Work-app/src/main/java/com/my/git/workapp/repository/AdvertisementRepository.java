package com.my.git.workapp.repository;

import com.my.git.workapp.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
}
