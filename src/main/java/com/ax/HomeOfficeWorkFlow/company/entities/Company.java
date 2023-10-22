package com.ax.HomeOfficeWorkFlow.company.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ax.HomeOfficeWorkFlow.employee.entities.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMPANIES")
@Getter
@Setter
public class Company implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private Cnpj cnpj;
  private Email email;
  private String name;
  private String fantasyName;
  private LocalDateTime openAt;
  private LocalDateTime registerAt;
  private Phone phone;
  private List<UUID> employees;

  public Company(Cnpj cnpj, Email email, String name, String fantasyName, LocalDateTime openAt, Phone phone) {
    this.id = UUID.randomUUID();
    this.cnpj = cnpj;
    this.email = email;
    this.name = name;
    this.fantasyName = fantasyName;
    this.openAt = openAt;
    this.registerAt = LocalDateTime.now();
    this.phone = phone;
    this.employees = new ArrayList<>();
  }
}
