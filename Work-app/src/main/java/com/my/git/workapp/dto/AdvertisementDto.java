package com.my.git.workapp.dto;

import com.my.git.workapp.RegionEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AdvertisementDto {

    private  Long id;

    private String title;

    private String category;

    private LocalDate dateAdd;

    private LocalDate expirationDate;

    private RegionEnum region;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateAdd() {
        return dateAdd;
    }

    public final void setDateAdd(LocalDate dateAdd) {
        this.dateAdd = dateAdd;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public RegionEnum getRegion() {
        return region;
    }

    public void setRegion(RegionEnum region) {
        this.region = region;
    }

    public AdvertisementDto() {
        this.dateAdd = LocalDate.now();
    }

    public AdvertisementDto(Long id,String title, String category, LocalDate expirationDate, RegionEnum region) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.dateAdd = LocalDate.now();
        this.expirationDate = expirationDate;
        this.region = region;
    }
}


