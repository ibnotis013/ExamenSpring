package edu.ledo.examen_cine.model.service;

import java.util.List;

import edu.ledo.examen_cine.model.dtos.PeliculaDetalleDTO;
import edu.ledo.examen_cine.model.dtos.PeliculaListadoDTO;
import edu.ledo.examen_cine.model.dtos.PeliculaRequestDTO;

public interface IPeliculaService {

    List<PeliculaListadoDTO> buscarPosterioresAAnio(int anio);

    List<PeliculaListadoDTO> listar();

    PeliculaDetalleDTO obtener(Long id);

    PeliculaDetalleDTO crear(PeliculaRequestDTO dto);

    PeliculaDetalleDTO actualizar(Long id, PeliculaRequestDTO dto);

    void eliminar(Long id);
}
