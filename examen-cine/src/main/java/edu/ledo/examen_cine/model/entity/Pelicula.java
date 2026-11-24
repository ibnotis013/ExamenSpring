package edu.ledo.examen_cine.entity;

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
    @Column(name = "")
    private Long id;
    
    @Column(name = "")
    private String titulo;
    private String director;
    private int anio;
    private int duracion;




}
