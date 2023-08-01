package com.example.pelisDisney.controller;

import com.example.pelisDisney.model.dto.PeliculaDto;
import com.example.pelisDisney.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/pelicula")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaSerieService){
        this.peliculaService = peliculaSerieService;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> getPeliculas(@RequestParam(name = "idPelicula",required = false)
                                                              Long idPelicula,@RequestParam(name = "titulo",required = false)
                                                          String titulo){
       if(idPelicula != null && titulo == null){
           return new ResponseEntity<>(peliculaService.getPelicula(idPelicula,titulo),HttpStatus.OK);
       }else if(idPelicula == null && titulo != null){
           return new ResponseEntity<>(peliculaService.getPelicula(idPelicula,titulo),
                   HttpStatus.OK);
       }else if(idPelicula != null && titulo != null){
           return new ResponseEntity<>(this.peliculaService.getPelicula(idPelicula, titulo),HttpStatus.OK);
       }else{
           return new ResponseEntity<>(this.peliculaService.getPelicula(idPelicula, titulo),HttpStatus.OK);
       }
    }

    @PostMapping("/crear")
    public ResponseEntity<PeliculaDto> postPelicula(@RequestBody PeliculaDto peliculaDto){
        return new ResponseEntity<>(this.peliculaService.postPelicula(peliculaDto),HttpStatus.CREATED);
    }
}
