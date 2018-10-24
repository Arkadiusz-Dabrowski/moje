package com.my.git.workapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Employer implements Serializable {
    @Id
    @GeneratedValue
    private Long employer_id;
    @Column(name = "company_name")
    private String companyName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employer")
    private Set<Advertisement> advertisement= new HashSet<>();

    public Employer(String companyName, String email, String phoneNumber) {
        this.companyName = companyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Employer() {
    }

    public Long getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(Long employer_id) {
        this.employer_id = employer_id;
    }

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
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find())
            this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Advertisement> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Set<Advertisement> advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + employer_id +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", advertisement=" + advertisement +
                '}';
    }
}

