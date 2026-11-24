package edu.ledo.examen_cine.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="pelicula")
public class Pelicula {


    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "titulo", length = 150, nullable = false,unique = true)
    private String titulo;
    
    
    @Column (name= "director", length = 100, nullable = false)
    private String director;
    
    
    @Column (name = "anio")
    private int anio;
    
    
    @Column (name = "duracion")
    private int duracion;


    @One



}
