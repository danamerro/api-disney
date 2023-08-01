package com.example.pelisDisney.model.dto;

import com.example.pelisDisney.model.entity.Personaje;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PeliculaDto {

    private Long idPelicula;
    @NotBlank(message = "falta el link de la imagen")
    private String imagen;
    @NotBlank(message = "falta el titulo de la pelicula o serie")
    private String titulo;
    private LocalDate fechaDeCreacion;
    private int calificacion;
    private List<Personaje> personajeAsociado;

    public PeliculaDto(Long idPelicula,
                       String imagen,
                       String titulo,
                       LocalDate fechaDeCreacion,
                       int calificacion,
                       List<Personaje> personajeAsociado) {
        this.idPelicula = idPelicula;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.calificacion = calificacion;
        this.personajeAsociado = personajeAsociado;
    }

    public PeliculaDto(Long idPelicula, String imagen, String titulo, LocalDate fechaDeCreacion, int calificacion) {
        this.idPelicula = idPelicula;
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.calificacion = calificacion;
    }

    public PeliculaDto() {
    }
}
