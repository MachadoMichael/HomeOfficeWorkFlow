package com.ax.HomeOfficeWorkFlow.employee.Entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cpf {
  private String register;

  public Cpf(String register){
    String cpfRegex = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";

    if(register.matches(cpfRegex)){
      this.register = register;
    }
    
  }

}


