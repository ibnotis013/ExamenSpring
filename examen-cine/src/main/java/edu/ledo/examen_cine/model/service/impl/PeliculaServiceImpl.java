package edu.ledo.examen_cine.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ledo.examen_cine.model.dtos.PeliculaDetalleDTO;
import edu.ledo.examen_cine.model.dtos.PeliculaListadoDTO;
import edu.ledo.examen_cine.model.dtos.PeliculaRequestDTO;
import edu.ledo.examen_cine.model.dtos.RepartoDTO;
import edu.ledo.examen_cine.model.entity.Pelicula;
import edu.ledo.examen_cine.model.entity.Reparto;
import edu.ledo.examen_cine.model.exception.ConflictoException;
import edu.ledo.examen_cine.model.exception.RecursoNoEncontradoException;
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
                .map(this::toListadoDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeliculaListadoDTO> listar() {
        return peliculaRepository.findAll().stream()
                .map(this::toListadoDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PeliculaDetalleDTO obtener(Long id) {
        return toDetalleDTO(buscarOFallar(id));
    }

    @Override
    @Transactional
    public PeliculaDetalleDTO crear(PeliculaRequestDTO dto) {
        validar(dto);
        if (peliculaRepository.existsByTituloIgnoreCase(dto.titulo())) {
            throw new ConflictoException("Ya existe una película con el título: " + dto.titulo());
        }
        Pelicula pelicula = new Pelicula();
        aplicar(pelicula, dto);
        return toDetalleDTO(peliculaRepository.save(pelicula));
    }

    @Override
    @Transactional
    public PeliculaDetalleDTO actualizar(Long id, PeliculaRequestDTO dto) {
        validar(dto);
        Pelicula pelicula = buscarOFallar(id);
        // Solo hay conflicto si el título cambia y ya lo tiene otra película
        if (!pelicula.getTitulo().equalsIgnoreCase(dto.titulo())
                && peliculaRepository.existsByTituloIgnoreCase(dto.titulo())) {
            throw new ConflictoException("Ya existe una película con el título: " + dto.titulo());
        }
        aplicar(pelicula, dto);
        return toDetalleDTO(peliculaRepository.save(pelicula));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        // El reparto se borra en cascada; los actores no
        peliculaRepository.delete(buscarOFallar(id));
    }

    private Pelicula buscarOFallar(Long id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe la película con id " + id));
    }

    private void validar(PeliculaRequestDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El cuerpo de la petición es obligatorio");
        }
        if (dto.titulo() == null || dto.titulo().isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (dto.director() == null || dto.director().isBlank()) {
            throw new IllegalArgumentException("El director no puede estar vacío");
        }
        if (dto.anio() < 1888) {
            throw new IllegalArgumentException("El año no puede ser anterior a 1888");
        }
        if (dto.duracion() <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que 0");
        }
    }

    private void aplicar(Pelicula pelicula, PeliculaRequestDTO dto) {
        pelicula.setTitulo(dto.titulo());
        pelicula.setDirector(dto.director());
        pelicula.setAnio(dto.anio());
        pelicula.setDuracion(dto.duracion());
    }

    private PeliculaListadoDTO toListadoDTO(Pelicula p) {
        return new PeliculaListadoDTO(p.getId(), p.getTitulo(), p.getDirector(), p.getAnio());
    }

    private PeliculaDetalleDTO toDetalleDTO(Pelicula p) {
        List<RepartoDTO> reparto = p.getRepartos().stream().map(this::toRepartoDTO).toList();
        return new PeliculaDetalleDTO(p.getId(), p.getTitulo(), p.getDirector(), p.getAnio(), p.getDuracion(),
                reparto);
    }

    private RepartoDTO toRepartoDTO(Reparto r) {
        return new RepartoDTO(
                r.getActor().getId(),
                r.getActor().getNombre(),
                r.getPersonaje(),
                r.getSalario() == null ? 0 : r.getSalario().doubleValue());
    }
}
