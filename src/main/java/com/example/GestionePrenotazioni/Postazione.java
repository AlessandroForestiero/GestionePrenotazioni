package com.example.GestionePrenotazioni;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;
import java.util.List;

@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int id;
    private String descrizione;
    private TipoPostazione tipo;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
}
