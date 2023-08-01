package com.example.pelisDisney.model.converter.DtoToEntityConverter;

import com.example.pelisDisney.model.dto.PersonajeDto;
import com.example.pelisDisney.model.entity.Personaje;
import org.springframework.stereotype.Component;

//el @Component sirve para indicar que en esta clase se va a implementar la inyeccion de dependencia.
@Component
public class
PersonajeDtoToEntityConverter {
    public Personaje toEntity(PersonajeDto personajeDto){
        return new Personaje(
                personajeDto.getIdPersonaje(),
                personajeDto.getImagen(),
                personajeDto.getNombre(),
                personajeDto.getEdad(),
                personajeDto.getPeso(),
                personajeDto.getHistoria()
        );
    }
}
