package com.ax.HomeOfficeWorkFlow.employee.services;

import com.ax.HomeOfficeWorkFlow.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthozirationService implements UserDetailsService {

    @Autowired
    EmployeeRepository repository;
    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        return repository.findByLogin(emailAddress);
    }
}
