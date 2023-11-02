package com.ax.HomeOfficeWorkFlow.company.repositories;

import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {
    public Phone findByNumber(String number);
}
