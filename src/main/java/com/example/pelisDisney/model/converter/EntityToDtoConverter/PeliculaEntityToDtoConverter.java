package com.example.pelisDisney.model.converter.EntityToDtoConverter;

import com.example.pelisDisney.model.dto.PeliculaDto;
import com.example.pelisDisney.model.entity.Pelicula;
import org.springframework.stereotype.Component;

@Component
public class PeliculaEntityToDtoConverter {

    public PeliculaDto toDto(Pelicula pelicula){

        return new PeliculaDto(
                pelicula.getIdPelicula(),
                pelicula.getImagen(),
                pelicula.getTitulo(),
                pelicula.getFechaDeCreacion(),
                pelicula.getCalificacion()
        );
    }
}

