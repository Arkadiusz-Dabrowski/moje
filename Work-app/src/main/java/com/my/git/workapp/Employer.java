package com.my.git.workapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Employer {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Employer(String companyName, String email, String phoneNumber) {
        this.companyName = companyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Employer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
