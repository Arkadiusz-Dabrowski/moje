package com.my.git.workapp.service;

import com.my.git.workapp.dto.EmployerDto;
import com.my.git.workapp.exception.NotFoundException;
import com.my.git.workapp.model.Employer;
import com.my.git.workapp.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    @Autowired
    EmployerRepository employerRepository;

    public void setEmployerRepository(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Employer getByCompanyName(String companyName) {
         Employer employer = (Optional.ofNullable(employerRepository.getEmployerByCompanyName(companyName)).orElseThrow(() ->new  NotFoundException("Employer not found")));
         return employer;
    }
    public Employer findById(Long id) {
        return employerRepository.findById(id).orElseThrow(() -> new NotFoundException(" Employer not exists"));

    }

    public List<Employer> findAll() {
        return employerRepository.findAll();
    }


    public Employer save(Employer employer) {
            return employerRepository.save(employer);
    }

    public void delateByID(Long id){
        employerRepository.deleteById(id);
    }


    public boolean existsById(Long id) {
        return employerRepository.existsById(id);
    }

    public Employer getOne(Long id) {
        return employerRepository.getOne(id);
    }

    public void update(EmployerDto employerDto){
        try {
            Employer employer = getOne(employerDto.getId());
            employer.setCompanyName(employerDto.getCompanyName());
            employer.setEmail(employerDto.getEmail());
            employer.setPhoneNumber(employerDto.getPhoneNumber());


            save(employer);
        } catch(EntityNotFoundException e){
            e.printStackTrace(System.out.printf("Pracodawca o podanym id nie istnieje"));
        }
    }
}
