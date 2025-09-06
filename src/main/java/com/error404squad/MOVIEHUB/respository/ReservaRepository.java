package com.error404squad.MOVIEHUB.respository;
import com.error404squad.MOVIEHUB.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}