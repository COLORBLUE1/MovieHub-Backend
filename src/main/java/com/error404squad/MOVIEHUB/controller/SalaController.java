package com.error404squad.MOVIEHUB.controller;

import com.error404squad.MOVIEHUB.model.Sala;
import com.error404squad.MOVIEHUB.service.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> getAll() {
        return salaService.getSalas();
    }

    @PostMapping
    public Sala create(@RequestBody Sala sala) {
        return salaService.saveSala(sala);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getById(@PathVariable Long id) {
        Optional<Sala> sala = salaService.getSalaById(id);
        return sala.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> update(@PathVariable Long id, @RequestBody Sala updatedSala) {
        Optional<Sala> optional = salaService.getSalaById(id);
        if (optional.isPresent()) {
            Sala sala = optional.get();
            sala.setNombre(updatedSala.getNombre());
            sala.setCapacidad(updatedSala.getCapacidad());
            Sala saved = salaService.saveSala(sala);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Sala> sala = salaService.getSalaById(id);
        if (sala.isPresent()) {
            salaService.deleteSala(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
