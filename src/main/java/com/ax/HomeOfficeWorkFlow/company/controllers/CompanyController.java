package com.ax.HomeOfficeWorkFlow.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class CompanyController {
  @Autowired
  CompanyService companyService;

  @GetMapping("/{cnpj}")
  public ResponseEntity<Object> get(@PathVariable(value = "cnpj") Cnpj cnpj) {
    try {
      Company selectedCompany = companyService.findByCnpj(cnpj);
      return ResponseEntity.status(HttpStatus.FOUND).body(selectedCompany);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cnpj.toString() + " not found");
    }
  }

  @GetMapping("/byFantasyName/{fantasyName}")
  public ResponseEntity<Object> getByFantasyName(@PathVariable(value = "fantasyName") String fantasyName) {
    try {
      Company selectedCompany = companyService.findByFantasyName(fantasyName);
      return ResponseEntity.status(HttpStatus.FOUND).body(selectedCompany);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fantasyName + " not found");
    }
  }

  @PostMapping("/add")
  public ResponseEntity<Object> add(@RequestBody NewCompanyDTO newCompanyDTO) {
    try {
      Company newCompany = new Company(
          newCompanyDTO.cnpj(),
          newCompanyDTO.email(),
          newCompanyDTO.name(),
          newCompanyDTO.fantasyName(),
          newCompanyDTO.openAt(),
          newCompanyDTO.phone());

      return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please confirm data in your request");
    }
  }

  @DeleteMapping("/{cnpj}")
  public ResponseEntity<Object> delete(@PathVariable(value = "cnpj") Cnpj cnpj) {
    try {
      Company company = companyService.findByCnpj(cnpj);
      companyService.delete(company);
      return ResponseEntity.status(HttpStatus.OK).body(cnpj.toString() + " delete with success");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.FOUND).body(cnpj.toString() + " not found.");
    }
  }
}
