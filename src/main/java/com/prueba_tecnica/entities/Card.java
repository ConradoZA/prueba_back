package com.prueba_tecnica.entities;

import com.prueba_tecnica.enums.CardsEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CARDS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Card {

    @Id
    private Integer cardNumber;

    private CardsEnum type;

    private Integer limit;

    private BigDecimal globalAmount;

    private BigDecimal drawnAmount;

    private Boolean activated = false;

    @ManyToOne
    @JoinColumn
    private Account account;
}
