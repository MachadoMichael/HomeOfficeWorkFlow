package com.ax.HomeOfficeWorkFlow.company.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ax.HomeOfficeWorkFlow.company.dtos.NewCompanyDTO;
import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.entities.Company;
import com.ax.HomeOfficeWorkFlow.company.services.CompanyService;

@RestController
@RequestMapping("companies")
public class CompanyController{
  @Autowired
  CompanyService companyService;

  @GetMapping("/{cnpj}")
  public ResponseEntity<Company> get(@PathVariable(value = "cnpj") Cnpj cnpj){
    Company selectedCompany = companyService.findByCnpj(cnpj);
    return ResponseEntity.status(HttpStatus.FOUND).body(selectedCompany);
  }

  @GetMapping("/byFantasyName/{fantasyName}")
  public ResponseEntity<Company> getByFantasyName(@PathVariable(value = "fantasyName") String fantasyName){
    Company selectedCompany = companyService.findByFantasyName(fantasyName);
    return ResponseEntity.status(HttpStatus.FOUND).body(selectedCompany);
  }

  @PostMapping("/add")
  public ResponseEntity<Company> add(@RequestBody NewCompanyDTO newCompanyDTO){
    Company newCompany = new Company(
            newCompanyDTO.cnpj(),
            newCompanyDTO.email(),
            newCompanyDTO.name(),
            newCompanyDTO.fantasyName(),
            newCompanyDTO.openAt(),
            newCompanyDTO.phone()
    );

  
    return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);
  }
}
