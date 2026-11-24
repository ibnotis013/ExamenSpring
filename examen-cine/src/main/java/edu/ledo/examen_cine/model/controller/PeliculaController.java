package edu.ledo.examen_cine.model.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.ledo.examen_cine.model.dtos.PeliculaDetalleDTO;
import edu.ledo.examen_cine.model.dtos.PeliculaListadoDTO;
import edu.ledo.examen_cine.model.dtos.PeliculaRequestDTO;
import edu.ledo.examen_cine.model.exception.ConflictoException;
import edu.ledo.examen_cine.model.exception.RecursoNoEncontradoException;
import edu.ledo.examen_cine.model.service.IPeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final IPeliculaService peliculaService;

    public PeliculaController(IPeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaListadoDTO>> listar() {
        return ResponseEntity.ok(peliculaService.listar());
    }
    @GetMapping("/buscar/{anio}")
    public ResponseEntity<List<PeliculaListadoDTO>> buscarPosterioresAAnio(@PathVariable int anio) {
        return ResponseEntity.ok(peliculaService.buscarPosterioresAAnio(anio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDetalleDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<PeliculaDetalleDTO> crear(@RequestBody PeliculaRequestDTO dto) {
        PeliculaDetalleDTO creada = peliculaService.crear(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creada.id())
                .toUri();
        return ResponseEntity.created(location).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDetalleDTO> actualizar(@PathVariable Long id, @RequestBody PeliculaRequestDTO dto) {
        return ResponseEntity.ok(peliculaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

   
}
