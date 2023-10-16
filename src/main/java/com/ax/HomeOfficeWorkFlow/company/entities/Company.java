package com.ax.HomeOfficeWorkFlow.company.entities;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

import com.ax.HomeOfficeWorkFlow.employee.Entities.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMPANIES")
@Getter
@Setter
@AllArgsConstructor
public class Company { 
  
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  private Cnpj cnpj;
  private Email email;
  private String name;
  private String fantasyName;
  private LocalDateTime createAt;
  private LocalDateTime openAt;
  private LocalDateTime closetAt;
  private Phone phone;
  private List<Employee> employees;
}
