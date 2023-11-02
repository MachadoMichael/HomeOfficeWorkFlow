package com.ax.HomeOfficeWorkFlow.employee.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Person {
  private String firstName;
  private String lastName;
  private Cpf cpf;
  private LocalDate bornAt;

  public Person(String firstName, String lastName, Cpf cpf, LocalDate bornAt) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cpf = cpf;
    this.bornAt = bornAt;

  }
}
