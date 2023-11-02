package com.ax.HomeOfficeWorkFlow.company.services;

import com.ax.HomeOfficeWorkFlow.company.entities.Cnpj;

public interface CnpjService {
    Cnpj save(Cnpj cnpj);

    Cnpj getOne(String register);

    void deleteOne(Cnpj cnpj);
}
