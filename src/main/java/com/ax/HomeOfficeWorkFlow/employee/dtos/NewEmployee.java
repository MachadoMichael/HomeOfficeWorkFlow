package com.ax.HomeOfficeWorkFlow.employee.dtos;

import java.time.LocalDateTime;

import com.ax.HomeOfficeWorkFlow.employee.entities.LoginRole;
import com.ax.HomeOfficeWorkFlow.employee.entities.Salary;

public record NewEmployee(
        String firstName,
        String lastName,
        String cpf,
        String companyFantasyName,
        Double grossSalary,
        Double bonus,
        Double lunchTime,
        Double dayWorkTime,
        String email,
        LoginRole loginRole,
        String login) {
}
