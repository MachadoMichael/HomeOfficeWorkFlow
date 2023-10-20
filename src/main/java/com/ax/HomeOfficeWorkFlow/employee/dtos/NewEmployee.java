package com.ax.HomeOfficeWorkFlow.employee.dtos;

import java.time.LocalDateTime;

import com.ax.HomeOfficeWorkFlow.company.entities.Company;
import com.ax.HomeOfficeWorkFlow.company.entities.Email;
import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;
import com.ax.HomeOfficeWorkFlow.employee.entities.LoginRole;
import com.ax.HomeOfficeWorkFlow.employee.entities.Salary;

public record NewEmployee(
    String firstName,
    String lastName,
    Cpf cpf,
    LocalDateTime bornAt,
    Company company,
    Salary salary,
    Double lunchTime,
    Double dayWorkTime,
    Email email,
    LoginRole loginRole
) {
}
