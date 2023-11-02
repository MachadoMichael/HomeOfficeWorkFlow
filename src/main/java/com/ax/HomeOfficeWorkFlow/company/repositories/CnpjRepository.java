package com.ax.HomeOfficeWorkFlow.company.repositories;

import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CnpjRepository extends JpaRepository<Cnpj, UUID> {
    public Cnpj findByRegister(String register);
}
