package edu.ledo.examen_cine.model.dtos;

public record PeliculaRequestDTO(
    String titulo,
    String director,
    int anio,
    int duracion
) {

}
