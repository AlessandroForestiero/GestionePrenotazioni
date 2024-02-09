package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.Postazione;
import com.example.GestionePrenotazioni.TipoPostazione;
import com.example.GestionePrenotazioni.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> getAllPostazioni() {
        return postazioneRepository.findAll();
    }

    public Postazione getPostazioneById(int id) {
        return postazioneRepository.findById(id).orElse(null);
    }

    public Postazione aggiungiPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public void eliminaPostazione(int id) {
        postazioneRepository.deleteById(id);
    }
    public List<Postazione> ricercaPostazionePerTipoECitta (TipoPostazione tipo, String citta){
        return postazioneRepository.findByTipoECitta(tipo, citta);
    }

    public Postazione modificaPostazione(int id, Postazione postazioneModificata) {
        Postazione postazioneEsistente = postazioneRepository.findById(id).orElse(null);

        if (postazioneEsistente != null) {
            postazioneEsistente.setDescrizione(postazioneModificata.getDescrizione());
            postazioneEsistente.setTipo(postazioneModificata.getTipo());


            return postazioneRepository.save(postazioneEsistente);
        }


        return null;
    }
}
