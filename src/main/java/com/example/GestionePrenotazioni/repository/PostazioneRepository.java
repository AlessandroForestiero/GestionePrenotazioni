package com.example.GestionePrenotazioni.repository;

import com.example.GestionePrenotazioni.Postazione;
import com.example.GestionePrenotazioni.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
   @Query("SELECT p FROM Postazione p JOIN p.edificio e WHERE p.tipo = :tipo AND e.citta = :citta")
    List<Postazione> findByTipoECitta(@Param("tipo")TipoPostazione tipo,@Param("citta") String citta);
}
