package com.example.pelisDisney.model.converter.DtoToEntityConverter;

import com.example.pelisDisney.model.dto.PeliculaDto;
import com.example.pelisDisney.model.entity.Pelicula;
import org.springframework.stereotype.Component;

@Component
public class PeliculaDtoToEntityConverter {

    public Pelicula toEntity(PeliculaDto peliculaDto){
        return new Pelicula(
                peliculaDto.getIdPelicula(),
                peliculaDto.getImagen(),
                peliculaDto.getTitulo(),
                peliculaDto.getFechaDeCreacion(),
                peliculaDto.getCalificacion()
        );
    }
}
