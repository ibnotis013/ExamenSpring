package edu.ledo.examen_cine.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="reparto")
public class Reparto {


    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "personaje", length = 100, nullable = false)
    private String personaje;
    

    @Column(name = "salario",precision = 5, scale = 2)
    private double salario;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pelicula_id")
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="actor_id")

}
