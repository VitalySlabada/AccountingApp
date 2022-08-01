package com.example.accountingapp.service;

import com.example.accountingapp.dto.CompanyDTO;
import com.example.accountingapp.entity.Company;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface CompanyService {
    List<CompanyDTO> listAllCompanies();

    CompanyDTO findById(Long Id);

    void save(CompanyDTO company);

    CompanyDTO update(CompanyDTO dto);

    CompanyDTO findByEmail(String email);

    void reopen(Long id);

    void close(Long id);

    BigDecimal findTaxByCompany();

    Company findCompanyByLoggedInUser();
}
