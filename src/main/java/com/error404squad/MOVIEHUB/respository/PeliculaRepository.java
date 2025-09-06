package com.error404squad.MOVIEHUB.respository;
import com.error404squad.MOVIEHUB.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}