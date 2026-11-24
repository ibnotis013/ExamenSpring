package edu.ledo.examen_cine.model.service;

import java.util.List;

import edu.ledo.examen_cine.model.dtos.PeliculaListadoDTO;

public interface IPeliculaService {

    List<PeliculaListadoDTO> buscarPosterioresAAnio(int anio);
}
