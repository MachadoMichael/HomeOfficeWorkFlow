package com.ax.HomeOfficeWorkFlow.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.entities.Company;
import com.ax.HomeOfficeWorkFlow.company.repositories.CompanyRepository;

@Service
public class CompanyServiceImp implements CompanyService {
  @Autowired
  CompanyRepository companyRepository;

  public Company findByCnpj(Cnpj cnpj) {
    return companyRepository.findByCnpj(cnpj);
  }

  public Company findByFantasyName(String fantasyName) {
    return companyRepository.findByFantasyName(fantasyName);
  }

  public Company save(Company company) {
    return companyRepository.save(company);
  }

  public void delete(Company company) {
    companyRepository.delete(company);
  }

}
