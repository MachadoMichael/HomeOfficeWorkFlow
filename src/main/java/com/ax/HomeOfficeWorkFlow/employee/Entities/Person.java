package com.ax.HomeOfficeWorkFlow.employee.entities;

import java.time.LocalDateTime;

import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
abstract class Person {
  private String firstName;
  private String lastName;
  private Cpf cpf;
  private LocalDateTime bornAt;

  public Person(String firstName, String lastName, Cpf cpf, LocalDateTime bornAt) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cpf = cpf;
    this.bornAt = bornAt;

  }
}
