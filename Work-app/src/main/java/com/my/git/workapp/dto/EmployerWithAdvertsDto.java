package com.my.git.workapp.dto;

import java.util.List;

public class EmployerWithAdvertsDto {

    private Long id;
    private String companyName;
    private String email;
    private String phoneNumber;
    private List<AdvertisementDto> advertisementDtoList;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AdvertisementDto> getAdvertisementDtoList() {
        return advertisementDtoList;
    }

    public void setAdvertisementDtoList(List<AdvertisementDto> advertisementDtoList) {
        this.advertisementDtoList = advertisementDtoList;
    }
}
