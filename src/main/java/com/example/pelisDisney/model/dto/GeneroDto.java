package com.example.pelisDisney.model.dto;

import com.example.pelisDisney.model.entity.Pelicula;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GeneroDto {
    private Long idGenero;
    @NotBlank(message = "falta el nombre")
    private String nombre;
    @NotBlank(message = "falta el link de la imagen")
    private String imagen;

    private List<Pelicula> peliculaAsociada;

    public GeneroDto(Long idGenero,
                     String nombre,
                     String imagen) {
        this.idGenero = idGenero;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public GeneroDto(Long idGenero, String nombre, String imagen, List<Pelicula> peliculaSerieAsociada) {
        this.idGenero = idGenero;
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculaAsociada = peliculaSerieAsociada;
    }

    public GeneroDto() {
    }
}
