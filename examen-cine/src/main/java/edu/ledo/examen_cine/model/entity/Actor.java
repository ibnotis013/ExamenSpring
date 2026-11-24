package edu.ledo.examen_cine.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="actor")
public class Actor {


    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    

    @Column(name = "nacionalidad", length = 60, nullable = false)
    private String nacionalidad;


    @OneToMany(mappedBy = "actor_id",cascade = CascadeType.ALL,orphanRemoval = true)
    

}