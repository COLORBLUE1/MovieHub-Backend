package com.error404squad.MOVIEHUB.service;

import com.error404squad.MOVIEHUB.model.Pelicula;
import com.error404squad.MOVIEHUB.respository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> getPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Optional<Pelicula> getPeliculaById(Long id) {
        return peliculaRepository.findById(id);
    }

    public void deletePelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}
