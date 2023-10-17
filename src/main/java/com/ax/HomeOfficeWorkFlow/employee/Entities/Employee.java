package com.ax.HomeOfficeWorkFlow.employee.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ax.HomeOfficeWorkFlow.company.entities.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends Person {
   @Id
   @GeneratedValue()
   private UUID id;

   private LocalDateTime hiredAt;
   private Double lunchTime;
   private Salary salary;
   private Double dayWorkTime;
   private Company company;

   public Employee(String firstName,
         String lastName,
         Cpf cpf,
         LocalDateTime bornAt,
         Company company,
         Salary salary,
         Double lunchTime,
         Double dayWorkTime) {
      super(firstName, lastName, cpf, bornAt);
      this.id = UUID.randomUUID();
      this.salary = salary;
      this.company = company;
      this.lunchTime = lunchTime;
      this.dayWorkTime = dayWorkTime;
   }
}
