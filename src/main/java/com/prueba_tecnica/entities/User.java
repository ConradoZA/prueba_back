package com.prueba_tecnica.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    private String dni;

    private String name;

    private String surnames;

    private Integer tlf;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Account> accounts;
}
