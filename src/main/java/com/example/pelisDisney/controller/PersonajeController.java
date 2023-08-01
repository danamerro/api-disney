package com.example.pelisDisney.controller;

import com.example.pelisDisney.model.dto.PersonajeDto;
import com.example.pelisDisney.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/personaje")
public class PersonajeController {
    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService){
        this.personajeService = personajeService;
    }

    @GetMapping()
        public ResponseEntity<List<PersonajeDto>> getPersonajes(@RequestParam(name = "idPersonaje",required = false)
                                                                Long idPersonaje, @RequestParam(name = "nombre",required = false)
                                                                    String nombre){
        if(idPersonaje != null && nombre == null){
            return new ResponseEntity<>(personajeService.getPersonaje(idPersonaje,nombre)
                    ,HttpStatus.OK);
        }else if(idPersonaje== null && nombre != null){
            return new ResponseEntity<>(personajeService.getPersonaje(idPersonaje, nombre),
                    HttpStatus.OK);
        }else if(idPersonaje!= null && nombre!= null){
            return new ResponseEntity<>(this.personajeService.getPersonaje(idPersonaje,nombre),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(this.personajeService.getPersonaje(idPersonaje,nombre),
                    HttpStatus.OK);
        }
        }

    @PostMapping("/crear")
    public ResponseEntity<PersonajeDto> postPersonaje(@RequestBody PersonajeDto personajeDto){
        return new ResponseEntity<>(this.personajeService.postPersonaje(personajeDto),HttpStatus.CREATED);
    }


}
