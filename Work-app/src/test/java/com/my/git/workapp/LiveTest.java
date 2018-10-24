package com.my.git.workapp;

import com.my.git.workapp.model.Employer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@SpringBootTest
public class LiveTest {


    private static final String API_ROOT
            = "/localhost:3306/test_db/employer";
    @PostMapping
    private Employer createRandomEmployer(){
        Employer employer = new Employer();
        employer.setCompanyName(randomAlphabetic(10));
        employer.setPhoneNumber(randomNumeric(12));
        return employer;
    }

}
