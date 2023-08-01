package com.example.pelisDisney.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;
    private String nombre;
    private String imagen;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Pelicula> peliculaAsociada;


    public Genero(Long idGenero, String nombre, String imagen, List<Pelicula> peliculaSerieAsociada) {
        this.idGenero = idGenero;
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculaAsociada = peliculaSerieAsociada;
    }

    public Genero(Long idGenero, String nombre, String imagen) {
        this.idGenero = idGenero;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Genero() {
    }
}
