package com.example.GestionePrenotazioni;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Utente {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String username;
    private String nomeCompleto;
    private String email;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;
}
