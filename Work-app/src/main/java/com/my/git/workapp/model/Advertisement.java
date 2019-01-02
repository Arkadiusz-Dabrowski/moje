package com.my.git.workapp.model;

import com.my.git.workapp.RegionEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Advertisement implements Serializable {

    @Id
    @GeneratedValue
    private Long advertisement_id;

    @Column(unique = true)
    private String title;

    private String category;

    private LocalDate dateAdd;

    private LocalDate expirationDate;

    private RegionEnum region;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Long getAdvertisement_id() {
        return advertisement_id;
    }

    public void setAdvertisement_id(Long advertisement_id) {
        this.advertisement_id = advertisement_id;
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

    public void setDateAdd(LocalDate dateAdd) {
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
}
