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
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonaje;

    private String imagen;
    private String nombre;
    private int edad;
    private float peso;
    private String historia;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Pelicula> peliculasSeriesAsociadas;

    public Personaje(Long idPersonaje, String imagen, String nombre, int edad, float peso, String historia,
                     List<Pelicula> peliculaSerieAsociada) {
        this.idPersonaje = idPersonaje;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculasSeriesAsociadas = peliculasSeriesAsociadas;
    }

    public Personaje(Long idPersonaje, String imagen, String nombre, int edad, float peso, String historia) {
        this.idPersonaje = idPersonaje;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }

    public Personaje() {
    }
}
