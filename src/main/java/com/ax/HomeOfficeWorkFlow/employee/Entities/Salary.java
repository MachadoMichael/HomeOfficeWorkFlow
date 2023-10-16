package com.ax.HomeOfficeWorkFlow.employee.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Salary {
  private Double totalCompensation;
  private Double grossValue;
  private Double bonus;

  public Salary(Double grossValue, Double bonus) {
    this.grossValue = grossValue;
    this.bonus = bonus;
    this.totalCompensation = grossValue + (grossValue * bonus);
  }
}
