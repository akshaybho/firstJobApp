package com.aksh.firstJobApp.company.impl;

import com.aksh.firstJobApp.company.entities.Company;
import com.aksh.firstJobApp.company.repositories.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyServiceImpl companyService;

    private Company company;

    @BeforeEach
    void setup()
    {
        company = new Company();
        company.setId(1L);
        company.setName("Test Company");
        company.setJobs(new ArrayList<>());
        company.setDescription("sample Description");
    }

    @Test
    void testGetAllCompanies()
    {
        List<Company> companies = List.of(company);
        when(companyRepository.findAll()).thenReturn(companies);

        List<Company> result = companyService.getAllCompanies();
        assertEquals(1, result.size());

        assertEquals("Test Company", result.get(0).getName());
        verify(companyRepository, times(1)).findAll();


    }
}