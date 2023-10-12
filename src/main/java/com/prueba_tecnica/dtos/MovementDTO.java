package com.prueba_tecnica.dtos;

import com.prueba_tecnica.enums.MovementEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Builder(toBuilder = true)
public class MovementDTO {
    private MovementEnum movementType;
    private BigDecimal amount;
    private LocalDate time;
}
