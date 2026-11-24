package edu.ledo.examen_cine.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ledo.examen_cine.model.entity.Pelicula;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Long>{
    

}
