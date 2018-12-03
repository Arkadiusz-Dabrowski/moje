package com.my.git.workapp.dto;

import com.my.git.workapp.RegionEnum;
import com.my.git.workapp.model.Employer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToOne;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Component
public class AdvertisementDto {


    private String title;

    private String Category;

    private Date dateAdd;

    private Date expirationDate;

    private RegionEnum region;

    @ManyToOne
    private Employer employer;


    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public final void setDateAdd(Date dateAdd) {
        this.dateAdd = Date.from(Instant.now());
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
}
