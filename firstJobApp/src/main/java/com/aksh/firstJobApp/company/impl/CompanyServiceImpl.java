package com.aksh.firstJobApp.company.impl;

import com.aksh.firstJobApp.company.entities.Company;
import com.aksh.firstJobApp.company.repositories.CompanyRepository;
import com.aksh.firstJobApp.company.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepo;
    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {

        Optional<Company> companyOptional = companyRepo.findById(id);
        if(companyOptional.isPresent())
        {
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyToUpdate.setJobs(company.getJobs());
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {

        companyRepo.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {

        if(companyRepo.existsById(id)) {
            companyRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {

        return companyRepo.findById(id)
                .orElse(null);
    }
}
