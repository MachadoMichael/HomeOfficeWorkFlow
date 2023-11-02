package com.ax.HomeOfficeWorkFlow.company.services;
import com.ax.HomeOfficeWorkFlow.company.entities.Phone;

public interface PhoneService {
    Phone save(Phone phone);
    Phone getOne(String register);
    void deleteOne(Phone phone);
}
