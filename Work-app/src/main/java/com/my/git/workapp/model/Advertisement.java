package com.my.git.workapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

@Entity
public class Advertisement implements Serializable {



    @Id
    @GeneratedValue
    private Long advertisement_id;
    private String title;
    private String Category;
    private Date dateAdd;
    private Date expirationDate;
    private String[] region= {"Warszawa", "Poznań", "Kraków", "Zakopane", "Gdańsk", "Szczecin", "Wrocław", "Śląsk"};
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id",nullable = false)
    private Employer employer;


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
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String[] getRegion() {
        return region;
    }

    public void setRegion(String[] region) {
        this.region = region;
    }

    public Advertisement(Employer employer) {
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + advertisement_id +
                ", title='" + title + '\'' +
                ", Category='" + Category + '\'' +
                ", dateAdd=" + dateAdd +
                ", expirationDate=" + expirationDate +
                ", region=" + Arrays.toString(region) +
                ", employer=" + employer +
                '}';
    }
}
