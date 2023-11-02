package com.ax.HomeOfficeWorkFlow.company.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PHONES")
@Getter
@Setter
public class Phone implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "phoneNumber", columnDefinition = "VARCHAR(11)")
  private String number;

  public Phone(String number) {
    String phoneRegex = "^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}-?\\d{4}$";

    if (number.matches(phoneRegex)) {
      this.number = number;
      this.id = UUID.randomUUID();
    }
  }
}
