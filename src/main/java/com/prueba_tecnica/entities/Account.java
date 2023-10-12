package com.prueba_tecnica.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "ACCOUNTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Account {

    @Id
    private String iban;

    private BigDecimal totalAmount;

    private String pin;

    @ManyToOne
    @JoinColumn(name = "dni")
    private User user;

    @OneToMany(mappedBy = "iban")
    @ToString.Exclude
    private Set<Movement> movements;

    @OneToMany(mappedBy = "cardNumber")
    @ToString.Exclude
    private Set<Card> cards;
}
