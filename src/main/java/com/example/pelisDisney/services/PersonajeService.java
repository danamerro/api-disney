package com.example.pelisDisney.services;

import com.example.pelisDisney.model.converter.DtoToEntityConverter.PersonajeDtoToEntityConverter;
import com.example.pelisDisney.model.converter.EntityToDtoConverter.PersonajeEntityToDtoConverter;
import com.example.pelisDisney.model.dto.PersonajeDto;
import com.example.pelisDisney.model.entity.Pelicula;
import com.example.pelisDisney.model.entity.Personaje;
import com.example.pelisDisney.repository.PeliculaRepository;
import com.example.pelisDisney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    private final PersonajeDtoToEntityConverter personajeDtoToEntityConverter;
    private final PersonajeEntityToDtoConverter personajeEntityToDtoConverter;
    private final PersonajeRepository personajeRepository;
    private final PeliculaRepository peliculaRepository;
    private final PeliculaService peliculaService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public PersonajeService(PersonajeDtoToEntityConverter personajeDtoToEntityConverter,
                            PersonajeEntityToDtoConverter personajeEntityToDtoConverter,
                            PersonajeRepository personajeRepository,
                            PeliculaRepository peliculaRepository,
                            PeliculaService peliculaService){

        this.personajeDtoToEntityConverter = personajeDtoToEntityConverter;

        this.personajeEntityToDtoConverter = personajeEntityToDtoConverter;

        this.personajeRepository = personajeRepository;

        this.peliculaRepository = peliculaRepository;

        this.peliculaService = peliculaService;


    }

    public List<PersonajeDto> getPersonaje(Long idPersonaje,String nombre){
        if(idPersonaje == null && nombre != null){
            Optional<List<Personaje>> personajeList = this.personajeRepository.findByNombre(nombre);
            return personajeList.get().stream().map(this.personajeEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else if(idPersonaje != null && nombre == null){
            Optional<List<Personaje>> personajeList = this.personajeRepository.findByIdPersonaje(idPersonaje);
            return personajeList.get().stream().map(this.personajeEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else if(idPersonaje != null && nombre != null){
            Optional<List<Personaje>> personajeList = this.personajeRepository.findByIdPersonajeAndNombre(idPersonaje,nombre);
            return personajeList.get().stream().map(this.personajeEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else{
            List<Personaje> personajes = this.personajeRepository.findAll();
            List<PersonajeDto> personajesDto = personajes.stream().map(personaje -> this.personajeEntityToDtoConverter.toDto(personaje)).collect(Collectors.toList());
            return personajesDto;
        }
    }

    public PersonajeDto postPersonaje(PersonajeDto personajeDto){
        peliculaService.
        Personaje personaje = personajeDtoToEntityConverter.toEntity(personajeDto);
        return personajeEntityToDtoConverter.toDto(personajeRepository.save(personaje));

    }



}
