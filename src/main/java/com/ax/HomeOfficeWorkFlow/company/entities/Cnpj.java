package com.ax.HomeOfficeWorkFlow.company.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CNPJ")
@Getter
@Setter
public class Cnpj implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "register", columnDefinition = "VARCHAR(18)")
  private String register;

  public Cnpj(String register) {
    String cnpjRegex = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$";

    if (register.matches(cnpjRegex)) {
      this.register = register;
      this.id = UUID.randomUUID();
    }
  }
}
