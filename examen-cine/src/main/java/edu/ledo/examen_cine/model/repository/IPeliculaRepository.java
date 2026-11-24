package edu.ledo.examen_cine.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ledo.examen_cine.model.entity.Pelicula;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Long>{

    boolean existsByTituloIgnoreCase(String titulo);

    List<Pelicula> findByAnioGreaterThanOrderByAnioAsc(int anio);
}
