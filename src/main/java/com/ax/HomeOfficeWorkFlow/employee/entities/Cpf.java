package com.ax.HomeOfficeWorkFlow.employee.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CPF")
@Getter
@Setter
public class Cpf implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "register", columnDefinition = "VARCHAR(11)")
  private String register;

  public Cpf(String register) {
    String cpfRegex = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";

    if (register.matches(cpfRegex)) {
      this.register = register;
    }

  }

}
