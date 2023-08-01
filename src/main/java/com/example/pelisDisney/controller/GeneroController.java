package com.example.pelisDisney.controller;

import com.example.pelisDisney.model.dto.GeneroDto;
import com.example.pelisDisney.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/genero")
public class GeneroController {

    private final GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService){
        this.generoService = generoService;
    }

    @GetMapping
    public ResponseEntity<List<GeneroDto>> getGeneros(@RequestParam(name = "idGenero",required = false)
                                                      Long idGenero,@RequestParam(name = "nombre",required = false)
                                                      String nombre){
        if(idGenero != null && nombre == null){
            return new ResponseEntity<>(generoService.getGenero(idGenero, nombre),HttpStatus.OK);
        } else if (idGenero == null && nombre != null) {
            return new ResponseEntity<>(generoService.getGenero(idGenero, nombre),HttpStatus.OK);
        }else if(idGenero != null && nombre != null){
            return new ResponseEntity<>(generoService.getGenero(idGenero, nombre),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(this.generoService.getGenero(idGenero, nombre), HttpStatus.OK);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<GeneroDto> postGenero(@RequestBody GeneroDto generoDto){
        return new ResponseEntity<>(this.generoService.postGenero(generoDto),HttpStatus.CREATED);
    }
}
