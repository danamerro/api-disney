package com.example.pelisDisney.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;
    private String imagen;
    private String titulo;
    private LocalDate fechaDeCreacion;
    private int calificacion;
    @ManyToMany(mappedBy = "peliculasSeriesAsociadas")
    @JsonBackReference
    private List<Personaje> personajeAsociado;

    public Pelicula(Long idPelicula, String imagen, String titulo, LocalDate fechaDeCreacion, int calificacion,
                    List<Personaje> personajeAsociado) {
        this.idPelicula = idPelicula;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.calificacion = calificacion;
        this.personajeAsociado = personajeAsociado;
    }

    public Pelicula(Long idPelicula, String imagen, String titulo, LocalDate fechaDeCreacion, int calificacion) {
        this.idPelicula = idPelicula;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.calificacion = calificacion;
    }

    public Pelicula() {
    }
}
