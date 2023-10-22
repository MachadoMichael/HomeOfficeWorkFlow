package com.ax.HomeOfficeWorkFlow.employee.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "SALARIES")
@Getter
@Setter
public class Salary implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "totalCompensation", columnDefinition = "VARCHAR(20)")
  private Double totalCompensation;
  private Double grossValue;
  private Double bonus;

  public Salary(Double grossValue, Double bonus) {
    this.grossValue = grossValue;
    this.bonus = bonus;
    this.totalCompensation = grossValue + (grossValue * bonus);
  }
}
