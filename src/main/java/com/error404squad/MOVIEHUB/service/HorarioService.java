package com.error404squad.MOVIEHUB.service;

import com.error404squad.MOVIEHUB.model.Horario;
import com.error404squad.MOVIEHUB.respository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<Horario> getHorarios() {
        return horarioRepository.findAll();
    }

    public Horario saveHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Optional<Horario> getHorarioById(Long id) {
        return horarioRepository.findById(id);
    }

    public void deleteHorario(Long id) {
        horarioRepository.deleteById(id);
    }
}
