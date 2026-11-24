package edu.ledo.examen_cine.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ledo.examen_cine.model.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Long>{

}
