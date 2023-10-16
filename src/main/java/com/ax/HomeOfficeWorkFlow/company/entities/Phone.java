package com.ax.HomeOfficeWorkFlow.company.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone {
  private String number;

  public Phone(String number) {
    String phoneRegex = "^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}-?\\d{4}$";

    if (number.matches(phoneRegex)) {
      this.number = number;
    }
  }
}
