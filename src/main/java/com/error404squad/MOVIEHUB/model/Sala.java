package com.error404squad.MOVIEHUB.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int capacidad;
}
