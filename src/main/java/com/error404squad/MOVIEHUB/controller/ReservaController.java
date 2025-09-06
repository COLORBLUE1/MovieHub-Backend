package com.error404squad.MOVIEHUB.controller;

import com.error404squad.MOVIEHUB.model.Reserva;
import com.error404squad.MOVIEHUB.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> getAll() {
        return reservaService.getReservas();
    }

    @PostMapping
    public Reserva create(@RequestBody Reserva reserva) {
        return reservaService.saveReserva(reserva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getById(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.getReservaById(id);
        return reserva.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Long id, @RequestBody Reserva updatedReserva) {
        Optional<Reserva> optional = reservaService.getReservaById(id);
        if (optional.isPresent()) {
            Reserva reserva = optional.get();
            reserva.setCodigoAcceso(updatedReserva.getCodigoAcceso());
            reserva.setCliente(updatedReserva.getCliente());
            reserva.setHorario(updatedReserva.getHorario());
            reserva.setPelicula(updatedReserva.getPelicula());
            reserva.setSala(updatedReserva.getSala());
            Reserva saved = reservaService.saveReserva(reserva);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.getReservaById(id);
        if (reserva.isPresent()) {
            reservaService.deleteReserva(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
