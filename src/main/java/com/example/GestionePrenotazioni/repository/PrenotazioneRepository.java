package com.example.GestionePrenotazioni.repository;

import com.example.GestionePrenotazioni.Prenotazione;
import com.example.GestionePrenotazioni.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate dataPrenotazione);


}
