package com.error404squad.MOVIEHUB.controller;

import com.error404squad.MOVIEHUB.model.Pelicula;
import com.error404squad.MOVIEHUB.service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> getAll() {
        return peliculaService.getPeliculas();
    }

    @PostMapping
    public Pelicula create(@RequestBody Pelicula pelicula) {
        return peliculaService.savePelicula(pelicula);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getById(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculaService.getPeliculaById(id);
        return pelicula.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> update(@PathVariable Long id, @RequestBody Pelicula updatedPelicula) {
        Optional<Pelicula> optional = peliculaService.getPeliculaById(id);
        if (optional.isPresent()) {
            Pelicula pelicula = optional.get();
            pelicula.setTitulo(updatedPelicula.getTitulo());
            pelicula.setDescripcion(updatedPelicula.getDescripcion());
            pelicula.setDuracion(updatedPelicula.getDuracion());
            pelicula.setGenero(updatedPelicula.getGenero());
            Pelicula saved = peliculaService.savePelicula(pelicula);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculaService.getPeliculaById(id);
        if (pelicula.isPresent()) {
            peliculaService.deletePelicula(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
