package edu.ledo.examen_cine.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ledo.examen_cine.model.dtos.PeliculaListadoDTO;
import edu.ledo.examen_cine.model.repository.IPeliculaRepository;
import edu.ledo.examen_cine.model.service.IPeliculaService;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

    private final IPeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(IPeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeliculaListadoDTO> buscarPosterioresAAnio(int anio) {
        return peliculaRepository.findByAnioGreaterThanOrderByAnioAsc(anio).stream()
                .map(p -> new PeliculaListadoDTO(p.getId(), p.getTitulo(), p.getDirector(), p.getAnio()))
                .toList();
    }
}
