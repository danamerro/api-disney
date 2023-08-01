package com.example.pelisDisney.model.converter.EntityToDtoConverter;

import com.example.pelisDisney.model.dto.GeneroDto;
import com.example.pelisDisney.model.entity.Genero;
import org.springframework.stereotype.Component;

@Component
public class GeneroEntityToDtoConverter {
    public GeneroDto toDto(Genero genero){
        return new GeneroDto(
                genero.getIdGenero(),
                genero.getNombre(),
                genero.getImagen()
        );
    }
}
