package com.ax.HomeOfficeWorkFlow.employee.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.ax.HomeOfficeWorkFlow.company.entities.Company;

import com.ax.HomeOfficeWorkFlow.company.entities.Email;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
public class Employee extends Person implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate hiredAt;
    private Double lunchTime;
    private Salary salary;
    private Double dayWorkTime;
    private Company company;
    private LoginRole loginRole;
    private Email email;
    private String login;

    public Employee(String firstName,
            String lastName,
            Cpf cpf,
            LocalDate bornAt,
            Company company,
            Salary salary,
            Double lunchTime,
            Double dayWorkTime,
            Email email,
            LoginRole loginRole,
            String login) {
        super(firstName, lastName, cpf, bornAt);
        this.id = UUID.randomUUID();
        this.salary = salary;
        this.company = company;
        this.lunchTime = lunchTime;
        this.dayWorkTime = dayWorkTime;
        this.email = email;
        this.loginRole = loginRole;
        this.login = login;
        this.hiredAt = LocalDate.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.loginRole == LoginRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email.getAddress();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
