package com.error404squad.MOVIEHUB.respository;
import com.error404squad.MOVIEHUB.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}
