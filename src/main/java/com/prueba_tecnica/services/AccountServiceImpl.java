package com.prueba_tecnica.services;

import com.prueba_tecnica.entities.Account;
import com.prueba_tecnica.entities.Movement;
import com.prueba_tecnica.repositories.AccountRepository;
import com.prueba_tecnica.repositories.MovementsRepository;
import com.prueba_tecnica.utils.Encrypter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@RequiredArgsConstructor
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final Encrypter encrypter;
    private final AccountRepository accountRepository;
    private final MovementsRepository movementsRepository;

    @Override
    public Set<Movement> getAllMovementsByAccountAndTime(String iban, String pin, LocalDate origin) throws Exception {
        Optional<Account> acc = accountRepository.findById(iban);
        if(acc.isEmpty()) throw new Exception("No existe esa cuenta");

        String encryptedPin = encrypter.encrypt(pin);
        if (!encrypter.isEncryptedValid(acc.get().getPin(), encryptedPin)) {
            throw new Exception("Pin Incorrecto");
        }

        return movementsRepository.findAllByIbanAndTime(iban, origin);
    }

    @Override
    public String withdrawMoneyFromCard(Integer cardNum, String pin, BigDecimal amount) {
        return null;
    }

    @Override
    public String depositMoneyFromCard(Integer cardNum, String pin, BigDecimal amount) {
        return null;
    }

    @Override
    public String nationalTransfer(String myIban, String theirIban, String pin, BigDecimal amount) {
        return null;
    }

    @Override
    public String activateCard(String iban, Integer cardNum) {
        return null;
    }

    @Override
    public String changePin(Integer cardNum, String oldPin) {
        return null;
    }

    private String createFirstPin() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
