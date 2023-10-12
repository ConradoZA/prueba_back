package com.prueba_tecnica.converters;

import com.prueba_tecnica.dtos.MovementDTO;
import com.prueba_tecnica.entities.Movement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@AllArgsConstructor
@Component
public class MovementMovementDTO {

    MovementDTO toDto(Movement mov) {
        return MovementDTO.builder()
                .movementType(mov.getMovementType())
                .amount(mov.getAmount())
                .time((mov.getTime()))
                .build();
    }
}
