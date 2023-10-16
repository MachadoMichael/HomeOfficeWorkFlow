package com.ax.HomeOfficeWorkFlow.company.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
  private String address;

  public Email(String address) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

    if (address.matches(emailRegex)) {
      this.address = address;
    }
  }
}
