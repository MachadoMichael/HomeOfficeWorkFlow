package com.ax.HomeOfficeWorkFlow.employee.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Salary {
  private Double totalCompensation;
  private Double grossValue;
  private Double bonus;
}
