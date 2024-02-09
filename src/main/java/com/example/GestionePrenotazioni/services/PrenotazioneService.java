package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.Prenotazione;
import com.example.GestionePrenotazioni.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione getPrenotazioneById(int id) {
        return prenotazioneRepository.findById(id).get();
    }

    public Prenotazione aggiungiPrenotazione(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public void eliminaPrenotazione(int id) {
        prenotazioneRepository.deleteById(id);
    }

    public Prenotazione modificaPrenotazione(int id, Prenotazione prenotazioneModificata) {
        Prenotazione prenotazioneEsistente = prenotazioneRepository.findById(id).orElse(null);

        if (prenotazioneEsistente != null) {
            prenotazioneEsistente.setPostazione(prenotazioneModificata.getPostazione());
            prenotazioneEsistente.setUtente(prenotazioneModificata.getUtente());
            prenotazioneEsistente.setData(prenotazioneModificata.getData());

            return prenotazioneRepository.save(prenotazioneEsistente);
        }

        return null;
    }
}

