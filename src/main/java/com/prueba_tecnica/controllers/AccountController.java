package com.prueba_tecnica.controllers;

import com.prueba_tecnica.dtos.MovementDTO;
import com.prueba_tecnica.entities.Movement;
import com.prueba_tecnica.services.AccountServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping("/movements")
    @ResponseBody
    public Set<MovementDTO> getMovements(@RequestBody String iban, @RequestBody String pin, @RequestBody String upTo) throws Exception {
        LocalDate upToTime = LocalDate.parse(upTo, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Set<Movement> movements = accountService.getAllMovementsByAccountAndTime(iban, pin, upToTime);

        return movements.stream().map(mov -> MovementDTO.builder().movementType(mov.getMovementType()).amount(mov.getAmount()).time(mov.getTime()).build()).collect(Collectors.toSet());
    }
}
