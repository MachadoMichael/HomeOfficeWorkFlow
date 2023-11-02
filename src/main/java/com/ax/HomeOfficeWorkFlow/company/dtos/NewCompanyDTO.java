package com.ax.HomeOfficeWorkFlow.company.dtos;



import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;
import com.ax.HomeOfficeWorkFlow.company.entities.Email;
import com.ax.HomeOfficeWorkFlow.company.entities.Phone;

import java.time.LocalDateTime;

public record NewCompanyDTO(
        String cnpj,
        String email,
        String name,
        String fantasyName,
        String phone,
        String openAt
) {
}
