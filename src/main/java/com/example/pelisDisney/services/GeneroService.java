package com.example.pelisDisney.services;

import com.example.pelisDisney.model.converter.DtoToEntityConverter.GeneroDtoToEntityConverter;
import com.example.pelisDisney.model.converter.EntityToDtoConverter.GeneroEntityToDtoConverter;
import com.example.pelisDisney.model.dto.GeneroDto;
import com.example.pelisDisney.model.entity.Genero;
import com.example.pelisDisney.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    private final GeneroDtoToEntityConverter generoDtoToEntityConverter;
    private final GeneroEntityToDtoConverter generoEntityToDtoConverter;
    private final GeneroRepository generoRepository;

    @Autowired
    public GeneroService(GeneroDtoToEntityConverter generoDtoToEntityConverter,
                         GeneroEntityToDtoConverter generoEntityToDtoConverter,
                         GeneroRepository generoRepository){
        this.generoDtoToEntityConverter = generoDtoToEntityConverter;
        this.generoEntityToDtoConverter = generoEntityToDtoConverter;
        this.generoRepository = generoRepository;

    }

    public List<GeneroDto> getGenero(Long idGenero,String nombre){
        if(idGenero == null && nombre != null){
            Optional<List<Genero>> generoList = this.generoRepository.findByNombre(nombre);
            return generoList.get().stream().map(this.generoEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else if(idGenero != null && nombre == null){
            Optional<List<Genero>> generoList = this.generoRepository.findByIdGenero(idGenero);
            return generoList.get().stream().map(this.generoEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else if(idGenero != null && nombre != null){
            Optional<List<Genero>> generoList = this.generoRepository.findByIdGeneroAndNombre(idGenero,nombre);
            return generoList.get().stream().map(this.generoEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else{
            List<Genero> generos = this.generoRepository.findAll();
            List<GeneroDto> generosDto = generos.stream().map(g -> this.generoEntityToDtoConverter.toDto(g))
                    .collect(Collectors.toList());
            return generosDto;
        }

    }

    public GeneroDto postGenero(GeneroDto generoDto){
        Genero genero = generoDtoToEntityConverter.toEntity(generoDto);
        return generoEntityToDtoConverter.toDto(generoRepository.save(genero));
    }


}
