package com.ax.HomeOfficeWorkFlow.company.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.repositories.CnpjRepository;

public class CnpjServiceImp implements CnpjService {
  @Autowired
  CnpjRepository cnpjRepository;

  public Cnpj save(Cnpj cnpj) {
    return cnpjRepository.save(cnpj);
  }

  public Cnpj getOne(String register) {
    return cnpjRepository.findByRegister(register);
  }

  public void deleteOne(Cnpj cnpj) {
    cnpjRepository.delete(cnpj);
  }
}
