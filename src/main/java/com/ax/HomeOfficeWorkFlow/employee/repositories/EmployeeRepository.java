package com.ax.HomeOfficeWorkFlow.employee.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ax.HomeOfficeWorkFlow.employee.entities.Cpf;
import com.ax.HomeOfficeWorkFlow.employee.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Employee findByLogin(String login);
}
