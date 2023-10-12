package com.prueba_tecnica.repositories;

import com.prueba_tecnica.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface MovementsRepository extends JpaRepository<Movement, String> {

    @Query("select * from Movement m where m.iban = :vIban and (:vTime is null or m.time <= :vTime")
    Set<Movement> findAllByIbanAndTime(@Param("vIban") String iban, @Param("vTime") LocalDate time);
}
