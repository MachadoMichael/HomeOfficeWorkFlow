package com.ax.HomeOfficeWorkFlow.company.repositories;

import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
    public Email findByAddress(String address);
}
