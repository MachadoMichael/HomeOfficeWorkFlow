package com.ax.HomeOfficeWorkFlow.dailylog.dtos;

import com.ax.HomeOfficeWorkFlow.company.entities.Company;
import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;

public record NewDailyLogDTO(
        Cpf cpf,
        Company company) {
}
