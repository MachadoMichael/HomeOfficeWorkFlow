package com.ax.HomeOfficeWorkFlow.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
  public Company findByCnpj(Cnpj cnpj);

  public Company findByFantasyName(String fantasyName);
}
