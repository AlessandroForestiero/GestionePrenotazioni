package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.Utente;
import com.example.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(int id) {
        return utenteRepository.findById(id).orElse(null);
    }

    public Utente aggiungiUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void eliminaUtente(int id) {
        utenteRepository.deleteById(id);
    }

    public Utente modificaUtente(int id, Utente utenteModificato) {
        Utente utenteEsistente = utenteRepository.findById(id).orElse(null);

        if (utenteEsistente != null) {
            utenteEsistente.setUsername(utenteModificato.getUsername());
            utenteEsistente.setNomeCompleto(utenteModificato.getNomeCompleto());
            utenteEsistente.setEmail(utenteModificato.getEmail());

            return utenteRepository.save(utenteEsistente);
        }

        return null;
    }
}

