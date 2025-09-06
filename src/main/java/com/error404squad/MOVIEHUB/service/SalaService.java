package com.error404squad.MOVIEHUB.service;

import com.error404squad.MOVIEHUB.model.Sala;
import com.error404squad.MOVIEHUB.respository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> getSalas() {
        return salaRepository.findAll();
    }

    public Sala saveSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public Optional<Sala> getSalaById(Long id) {
        return salaRepository.findById(id);
    }

    public void deleteSala(Long id) {
        salaRepository.deleteById(id);
    }
}
