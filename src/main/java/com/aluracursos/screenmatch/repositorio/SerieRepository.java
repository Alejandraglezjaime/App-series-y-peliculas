package com.aluracursos.screenmatch.repositorio;

import com.aluracursos.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);

    //PARA EL TOP 5 DE LAS SERIES QUE ESTAN EN LA BASE DE DATOS
    List<Serie> findTop5ByOrderByEvaluacionDesc();

}
