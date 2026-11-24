package edu.ledo.examen_cine.model.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ledo.examen_cine.model.dtos.PeliculaListadoDTO;
import edu.ledo.examen_cine.model.service.IPeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final IPeliculaService peliculaService;

    public PeliculaController(IPeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    // GET /api/peliculas/buscar/2015
    @GetMapping("/buscar/{anio}")
    public ResponseEntity<List<PeliculaListadoDTO>> buscarPosterioresAAnio(@PathVariable int anio) {
        return ResponseEntity.ok(peliculaService.buscarPosterioresAAnio(anio));
    }
}
