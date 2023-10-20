package com.ax.HomeOfficeWorkFlow.company.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ax.HomeOfficeWorkFlow.employee.entities.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
  private Cnpj cnpj;
  private Email email;
  private String name;
  private String fantasyName;
  private LocalDateTime openAt;
  private LocalDateTime registerAt;
  private Phone phone;
  private List<Employee> employees;

  public Company(Cnpj cnpj, Email email, String name, String fantasyName, LocalDateTime openAt, Phone phone) {
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
