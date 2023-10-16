package com.ax.HomeOfficeWorkFlow.employee.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
abstract class Person {
  private String firstName;
  private String lastName;
  private Cpf cpf;
  private LocalDateTime bornAt;
}
