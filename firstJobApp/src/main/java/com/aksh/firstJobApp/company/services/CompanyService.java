package com.aksh.firstJobApp.company.services;

import com.aksh.firstJobApp.company.entities.Company;

import java.util.List;

public interface CompanyService {

    List <Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);
}
