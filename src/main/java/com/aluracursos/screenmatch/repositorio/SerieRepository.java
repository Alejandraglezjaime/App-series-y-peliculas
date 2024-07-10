package com.aluracursos.screenmatch.repositorio;

import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);
        //Ocupamos opcional porque puede regresarnos o no un titulo

    boolean existsByTitulo(String titulo);

    //PARA EL TOP 5 DE LAS SERIES QUE ESTAN EN LA BASE DE DATOS
    List<Serie> findTop5ByOrderByEvaluacionDesc();
        //Ocupamos una lista porque forzosamente debe regresarnos algo



    //BUSCAR SERIE POR CATEGORIA
    List<Serie> findByGenero(Categoria categoria);

    //List<Serie> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas,Double Evaluacion);

    // @Query( value = "SELECT * FROM series WHERE series.total_temporadas <= 6 AND series.evaluacion >= 8",nativeQuery = true)
        //Aquí hacemos fijo la selección en la base de datos

    @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")

    List<Serie> seriesPorTemporadaYEvaluacion(int totalTemporadas,Double evaluacion);


    //BUSCAR EPISODIOS POR NOMBRE
    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:nombreEpisodio%")
    List<Episodio> episodiosPorNombre(String nombreEpisodio);

    //TOP 5 EPISODIOS POR SERIE


    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.evaluacion DESC LIMIT 5 ")
    List<Episodio> top5Episodios(Serie serie);

    @Query("SELECT e FROM Episodio e ORDER BY e.evaluacion DESC LIMIT 10")
    List<Episodio> top5EpisodiosGeneral();

}
