package com.prueba_tecnica.entities;

import com.prueba_tecnica.enums.MovementEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "MOVEMENTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movement {

    // ID compuesto por las cuatro columnas
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "iban")
    private String iban;

    private MovementEnum movementType;

    private BigDecimal amount;

    private LocalDate time;
}
