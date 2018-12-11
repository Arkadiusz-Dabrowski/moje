package com.my.git.workapp.dto;

import com.my.git.workapp.RegionEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class AdvertisementDto {

    private  Long id;

    private String title;

    private String category;

    private Date dateAdd;

    private Date expirationDate;

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
        category = category;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public final void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public RegionEnum getRegion() {
        return region;
    }

    public void setRegion(RegionEnum region) {
        this.region = region;
    }

    public AdvertisementDto() {
        this.dateAdd = java.sql.Date.valueOf(LocalDate.now());
    }

    public AdvertisementDto(Long id,String title, String category, Date dateAdd, Date expirationDate, RegionEnum region) {
        this.id = id;
        this.title = title;
        category = category;
        this.dateAdd = java.sql.Date.valueOf(LocalDate.now());
        this.expirationDate = expirationDate;
        this.region = region;
    }
}


