package com.error404squad.MOVIEHUB.controller;

import com.error404squad.MOVIEHUB.model.Horario;
import com.error404squad.MOVIEHUB.service.HorarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping
    public List<Horario> getAll() {
        return horarioService.getHorarios();
    }

    @PostMapping
    public Horario create(@RequestBody Horario horario) {
        return horarioService.saveHorario(horario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getById(@PathVariable Long id) {
        Optional<Horario> horario = horarioService.getHorarioById(id);
        return horario.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> update(@PathVariable Long id, @RequestBody Horario updatedHorario) {
        Optional<Horario> optional = horarioService.getHorarioById(id);
        if (optional.isPresent()) {
            Horario horario = optional.get();
            horario.setFechaHora(updatedHorario.getFechaHora());
            Horario saved = horarioService.saveHorario(horario);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Horario> horario = horarioService.getHorarioById(id);
        if (horario.isPresent()) {
            horarioService.deleteHorario(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
