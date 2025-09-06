package com.error404squad.MOVIEHUB.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Pelicula pelicula;

    @ManyToOne
    private Horario horario;

    @ManyToOne
    private Sala sala;

    private String codigoAcceso;
}
