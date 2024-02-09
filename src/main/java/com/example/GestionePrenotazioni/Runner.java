package com.example.GestionePrenotazioni;

import com.example.GestionePrenotazioni.services.EdificioService;
import com.example.GestionePrenotazioni.services.PostazioneService;
import com.example.GestionePrenotazioni.services.PrenotazioneService;
import com.example.GestionePrenotazioni.services.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final EdificioService edificioService;
    private final PostazioneService postazioneService;
    private final UtenteService utenteService;
    private final PrenotazioneService prenotazioneService;
    private final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Autowired
    public Runner(EdificioService edificioService, PostazioneService postazioneService, UtenteService utenteService, PrenotazioneService prenotazioneService) {
        this.edificioService = edificioService;
        this.postazioneService = postazioneService;
        this.utenteService = utenteService;
        this.prenotazioneService = prenotazioneService;
    }

    @Override
    public void run(String... args) {
        try {
            Edificio edificio = new Edificio();
            edificio.setNome("Edificio1");
            edificio.setIndirizzo("Via Inter, 1");
            edificio.setCitta("Milano");
            edificioService.aggiungiEdificio(edificio);
            logger.info("Edificio creato");

        } catch (Exception e) {
            logger.error("Errore durante la gestione dell'edificio", e);
        }

        try {
            Postazione postazione = new Postazione();
            postazione.setId(1);
            postazione.setDescrizione("Postazione 1");
            postazione.setTipo(TipoPostazione.PRIVATO);
            postazioneService.aggiungiPostazione(postazione);
            logger.info("Postazione creata");

        } catch (Exception e) {
            logger.error("Errore durante la gestione della postazione", e);
        }

        try {
            Utente utente = new Utente();
            utente.setUsername("user1");
            utente.setNomeCompleto("Nome Utente 1");
            utente.setEmail("user1@example.com");
            utenteService.aggiungiUtente(utente);
            logger.info("Utente creato");

        } catch (Exception e) {
            logger.error("Errore durante la gestione dell'utente", e);
        }

        try {
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setPostazione(postazioneService.getPostazioneById(2));
            prenotazione.setUtente(utenteService.getUtenteById(1));
            prenotazioneService.aggiungiPrenotazione(prenotazione);
            logger.info("Prenotazione creata");

        } catch (Exception e) {
            logger.error("Errore durante la gestione della prenotazione", e);
        }
        try {
            TipoPostazione tipo = TipoPostazione.PRIVATO;
            String citta = "Milano";

            List<Postazione> postazioniTrovate = postazioneService.ricercaPostazionePerTipoECitta(tipo, citta);

            if (!postazioniTrovate.isEmpty()) {
                logger.info("Postazioni trovate per tipo {} e città {}: {}", tipo, citta, postazioniTrovate);
            } else {
                logger.info("Nessuna postazione trovata per tipo {} e città {}", tipo, citta);
            }
        } catch (Exception e) {
            logger.error("Errore durante la ricerca di postazioni per tipo e città", e);
        }
    }
}

