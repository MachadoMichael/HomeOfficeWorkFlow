package com.ax.HomeOfficeWorkFlow.company.services;

import com.ax.HomeOfficeWorkFlow.company.entities.Phone;
import com.ax.HomeOfficeWorkFlow.company.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneServiceImp implements PhoneService {

    @Autowired
    PhoneRepository phoneRepository;

    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    };

    public Phone getOne(String number){
        return phoneRepository.findByNumber(number);
    };

    public void deleteOne(Phone phone){
        phoneRepository.delete(phone);
    };

}
