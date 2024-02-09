package com.example.GestionePrenotazioni;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Edificio {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;
    private int numeroMassimoOccupanti;
    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;


}
