package com.ax.HomeOfficeWorkFlow.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;
import com.ax.HomeOfficeWorkFlow.employee.entities.Employee;
import com.ax.HomeOfficeWorkFlow.employee.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Employee findByCpf(Cpf cpf) {
    return employeeRepository.findByCpf(cpf);
  }

  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  public void delete(Employee employee) {
    employeeRepository.delete(employee);
  }
}
