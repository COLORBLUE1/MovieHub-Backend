package com.error404squad.MOVIEHUB.service;

import com.error404squad.MOVIEHUB.model.Reserva;
import com.error404squad.MOVIEHUB.respository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
