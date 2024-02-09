package com.example.GestionePrenotazioni;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"data_prenotazione","utente_id"}),
        @UniqueConstraint(columnNames = {"postazione_id","data_prenotazione"})
})
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;


}
