package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.Edificio;
import com.example.GestionePrenotazioni.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public List<Edificio> getAllEdifici() {
        return edificioRepository.findAll();
    }

    public Edificio getEdificioById(int id) {
        return edificioRepository.findById(id).orElse(null);
    }

    public Edificio aggiungiEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public void eliminaEdificio(int id) {
        edificioRepository.deleteById(id);
    }

    public Edificio modificaEdificio(int id, Edificio edificioModificato) {
        Edificio edificioEsistente = edificioRepository.findById(id).orElse(null);

        if (edificioEsistente != null) {
            edificioEsistente.setNome(edificioModificato.getNome());
            edificioEsistente.setIndirizzo(edificioModificato.getIndirizzo());
            edificioEsistente.setCitta(edificioModificato.getCitta());

            return edificioRepository.save(edificioEsistente);
        }

        return null;
    }
}

