package com.ax.HomeOfficeWorkFlow.company.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "EMAILS")
@Getter
@Setter
public class Email implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "address", columnDefinition = "VARCHAR(50)")
  private String address;

  public Email(String address) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

    if (address.matches(emailRegex)) {
      this.address = address;
    }
  }
}
