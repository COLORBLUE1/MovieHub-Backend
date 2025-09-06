package com.error404squad.MOVIEHUB.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String genero;
    private int duracion;
}
