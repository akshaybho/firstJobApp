package com.aksh.firstJobApp.company.repositories;

import com.aksh.firstJobApp.company.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
