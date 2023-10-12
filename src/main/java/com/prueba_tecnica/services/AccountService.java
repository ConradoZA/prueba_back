package com.prueba_tecnica.services;

import com.prueba_tecnica.entities.Movement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public interface AccountService {
    Set<Movement> getAllMovementsByAccountAndTime(String iban, String pin, LocalDate origin);
    String withdrawMoneyFromCard(Integer cardNum, String pin, BigDecimal amount);
    String depositMoneyFromCard(Integer cardNum, String pin, BigDecimal amount);
    String nationalTransfer(String myIban, String theirIban, String pin, BigDecimal amount);
    String activateCard(String iban, Integer cardNum);
    String changePin(Integer cardNum, String oldPin);
}
