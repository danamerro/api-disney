package com.example.pelisDisney.model.converter.DtoToEntityConverter;

import com.example.pelisDisney.model.dto.GeneroDto;
import com.example.pelisDisney.model.entity.Genero;
import org.springframework.stereotype.Component;

@Component
public class GeneroDtoToEntityConverter {
    public Genero toEntity(GeneroDto generoDto){
        return new Genero(
                generoDto.getIdGenero(),
                generoDto.getNombre(),
                generoDto.getImagen()
        );
    }
}
