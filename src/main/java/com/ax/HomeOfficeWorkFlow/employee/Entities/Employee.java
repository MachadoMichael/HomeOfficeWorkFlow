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
public class Employee extends Person {
   private LocalDateTime hiredAt;
   private Double lunchTime;
   private Salary salary;
   private Double dayWorkTime;
}
