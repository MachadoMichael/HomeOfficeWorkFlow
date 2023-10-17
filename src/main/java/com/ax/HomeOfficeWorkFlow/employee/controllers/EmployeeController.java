package com.ax.HomeOfficeWorkFlow.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ax.HomeOfficeWorkFlow.employee.dtos.NewEmployee;
import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;
import com.ax.HomeOfficeWorkFlow.employee.entities.Employee;
import com.ax.HomeOfficeWorkFlow.employee.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<Object> getAll() {
    try {

      return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check your request");
    }
  }

  @GetMapping("/{cpf}")
  public ResponseEntity<Object> getByCpf(@PathVariable(value = "cpf") Cpf cpf) {
    try {
      return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.findByCpf(cpf));

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
    }
  }

  @PutMapping
  public ResponseEntity<Object> save(@RequestBody NewEmployee newEmployee) {
    try {
      Employee employee = new Employee(newEmployee.fisrtName(),
          newEmployee.lastName(),
          newEmployee.cpf(),
          newEmployee.bornAt(),
          newEmployee.company(),
          newEmployee.salary(),
          newEmployee.lunchTime(),
          newEmployee.dayWorkTime());

      return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check your request");
    }

  }

  @DeleteMapping("/{cpf}")
  public ResponseEntity<Object> delete(@PathVariable(value = "cpf") Cpf cpf) {
    try {
      Employee selectedEmployee = employeeService.findByCpf(cpf);

      employeeService.delete(selectedEmployee);
      return ResponseEntity.status(HttpStatus.OK).body("Employee with cpf equal " + cpf + "deleted with success");

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
    }
  }
}
