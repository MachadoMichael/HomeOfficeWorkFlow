package com.ax.HomeOfficeWorkFlow.employee.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;
import com.ax.HomeOfficeWorkFlow.employee.entities.Employee;

@Repository
public interface EmployeeService {

  public List<Employee> findAll();

  public Employee save(Employee employee);

  public void delete(Employee company);
}
