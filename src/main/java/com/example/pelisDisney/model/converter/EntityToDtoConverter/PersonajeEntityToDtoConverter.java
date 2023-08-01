package com.example.pelisDisney.model.converter.EntityToDtoConverter;

import com.example.pelisDisney.model.dto.PersonajeDto;
import com.example.pelisDisney.model.entity.Personaje;
import org.springframework.stereotype.Component;

@Component
public class PersonajeEntityToDtoConverter {

    public PersonajeDto toDto(Personaje personaje){

        return new PersonajeDto(
                personaje.getIdPersonaje(),
                personaje.getImagen(),
                personaje.getNombre(),
                personaje.getEdad(),
                personaje.getPeso(),
                personaje.getHistoria()
        );
    }
}
