package com.ax.HomeOfficeWorkFlow.company.services;

import com.ax.HomeOfficeWorkFlow.company.entities.Email;

public interface EmailService {

    Email save(Email email);
    Email getOne(String register);
    void deleteOne(String register);
}
