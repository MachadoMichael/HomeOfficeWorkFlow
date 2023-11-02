package com.ax.HomeOfficeWorkFlow.employee.controllers;

import com.ax.HomeOfficeWorkFlow.company.entities.Company;
import com.ax.HomeOfficeWorkFlow.company.entities.Email;
import com.ax.HomeOfficeWorkFlow.company.services.CompanyService;
import com.ax.HomeOfficeWorkFlow.company.services.CompanyServiceImp;
import com.ax.HomeOfficeWorkFlow.employee.entities.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ax.HomeOfficeWorkFlow.employee.dtos.NewEmployee;
import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;
import com.ax.HomeOfficeWorkFlow.employee.entities.Employee;
import com.ax.HomeOfficeWorkFlow.employee.services.EmployeeService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CompanyService companyService;

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
            List<Employee> selectedEmployee = employeeService.findAll().stream()
                    .filter(employee -> employee.getCpf().equals(cpf)).toList();

            return ResponseEntity.status(HttpStatus.FOUND).body(selectedEmployee);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> save(@RequestBody NewEmployee newEmployee) {
        try {
            Company company = companyService.findByFantasyName(newEmployee.companyFantasyName());
            Salary salary = new Salary(newEmployee.grossSalary(), newEmployee.bonus());

            Employee employee = new Employee(newEmployee.firstName(),
                    newEmployee.lastName(),
                    new Cpf(newEmployee.cpf()),
                    LocalDate.now(),
                    company,
                    salary,
                    newEmployee.lunchTime(),
                    newEmployee.dayWorkTime(),
                    new Email(newEmployee.email()),
                    newEmployee.loginRole(),
                    newEmployee.login());

            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check your request");
        }

    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> delete(@PathVariable(value = "cpf") Cpf cpf) {
        try {
            List<Employee> selectedEmployees = employeeService.findAll().stream()
                    .filter(employee -> employee.getCpf().equals(cpf)).toList();

            if (!selectedEmployees.isEmpty()) {

                for (int i = 0; i < selectedEmployees.size(); i++) {
                    employeeService.delete(selectedEmployees.get(i));
                }
            }

            return ResponseEntity.status(HttpStatus.OK).body("Employee with cpf equal " + cpf + "deleted with success");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }
}
