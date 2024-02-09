package com.example.GestionePrenotazioni.repository;

import com.example.GestionePrenotazioni.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}
