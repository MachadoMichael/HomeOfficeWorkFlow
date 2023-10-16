package com.ax.HomeOfficeWorkFlow.company.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cnpj {
  private String register;

  public Cnpj(String register) {
    String cnpjRegex = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$";

    if (register.matches(cnpjRegex)) {
      this.register = register;
    }
  }
}
