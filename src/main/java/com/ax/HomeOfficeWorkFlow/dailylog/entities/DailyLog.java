package com.ax.HomeOfficeWorkFlow.dailylog.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ax.HomeOfficeWorkFlow.company.entities.Company;
import com.ax.HomeOfficeWorkFlow.employee.Entities.Cpf;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DailyLog{
  private UUID id;
  private Cpf cpf;
  private Company company;
  private LocalDateTime startAt;
  private LocalDateTime lunchTime;
  private LocalDateTime endedAt;
  private LocalDateTime workedTime;
  private LocalDateTime balanceHoursWorked;

  public DailyLog(Cpf cpf, Company company){
    if(cpf != null && company != null){
      this.id = UUID.randomUUID();
      this.cpf = cpf;
      this.company = company;
      this.startAt = LocalDateTime.now();
    }
  }
}
