package com.ax.HomeOfficeWorkFlow.company.services;

import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.entities.Company;

public interface CompanyService {
  public Company findByCnpj(Cnpj cnpj);

  public Company findByFantasyName(String fantasyName);

  public Company save(Company company);

  public void delete(Company company);
}
