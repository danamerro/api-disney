package com.example.pelisDisney.services;

import com.example.pelisDisney.model.converter.DtoToEntityConverter.PeliculaDtoToEntityConverter;
import com.example.pelisDisney.model.converter.EntityToDtoConverter.PeliculaEntityToDtoConverter;
import com.example.pelisDisney.model.dto.PeliculaDto;
import com.example.pelisDisney.model.entity.Pelicula;
import com.example.pelisDisney.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeliculaService {

    private final PeliculaDtoToEntityConverter peliculaSerieDtoToEntityConverter;

    private final PeliculaEntityToDtoConverter peliculaEntityToDtoConverter;

    private final PeliculaRepository peliculaRepository;

    @Autowired
    public PeliculaService(PeliculaDtoToEntityConverter peliculaSerieDtoToEntityConverter,
                           PeliculaEntityToDtoConverter peliculaEntityToDtoConverter,
                           PeliculaRepository peliculaRepository){
        this.peliculaSerieDtoToEntityConverter = peliculaSerieDtoToEntityConverter;
        this.peliculaEntityToDtoConverter = peliculaEntityToDtoConverter;
        this.peliculaRepository = peliculaRepository;
    }

    public List<PeliculaDto> getPelicula(Long idPelicula,String titulo){
        if(idPelicula == null && titulo !=null){
            Optional<List<Pelicula>> peliculaList = this.peliculaRepository.findByTitulo(titulo);
            return peliculaList.get().stream().map(this.peliculaEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else if(idPelicula!= null && titulo == null){
            Optional<List<Pelicula>> peliculaList = this.peliculaRepository.findByIdPelicula(idPelicula);
            return peliculaList.get().stream().map(this.peliculaEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else if(idPelicula != null && titulo != null){
            Optional<List<Pelicula>> peliculaList = this.peliculaRepository.findByIdPeliculaAndTitulo(idPelicula,titulo);
            return peliculaList.get().stream().map(this.peliculaEntityToDtoConverter::toDto)
                    .collect(Collectors.toList());
        }else{
            List<Pelicula> peliculas = this.peliculaRepository.findAll();
            List<PeliculaDto> peliculasDto = peliculas.stream().map(peli -> this.peliculaEntityToDtoConverter.toDto(peli))
                    .collect(Collectors.toList());
            return peliculasDto;
        }
    }

    public PeliculaDto postPelicula(PeliculaDto peliculaDto){
        Pelicula pelicula = peliculaSerieDtoToEntityConverter.toEntity(peliculaDto);
        return peliculaEntityToDtoConverter.toDto(peliculaRepository.save(pelicula));
    }

    public Pelicula findById(Long id){
        Pelicula pelicula = peliculaRepository.findById(id).orElseThrow("El id de la pelicula: "+id+"no exoste")
        );
    }
}
