package com.ax.HomeOfficeWorkFlow.company.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ax.HomeOfficeWorkFlow.employee.entities.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COMPANIES")
@Getter
@Setter
@NoArgsConstructor
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
  private LocalDate openAt;
  private LocalDate registerAt;
  private Phone phone;
  private List<UUID> employees;

  public Company(Cnpj cnpj, Email email, String name, String fantasyName, LocalDate openAt, Phone phone) {
    this.id = UUID.randomUUID();
    this.cnpj = cnpj;
    this.email = email;
    this.name = name;
    this.fantasyName = fantasyName;
    this.openAt = openAt;
    this.registerAt = LocalDate.now();
    this.phone = phone;
    this.employees = new ArrayList<>();
  }
}
