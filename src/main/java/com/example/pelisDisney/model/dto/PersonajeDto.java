package com.example.pelisDisney.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString


public class PersonajeDto {
    private Long idPersonaje;
    @NotBlank(message = "falta la imagen")
    private String imagen;
    @NotBlank(message = "falta el nombre")
    private String nombre;
    private int edad;
    private float peso;
    private String historia;

    public PersonajeDto(Long idPersonaje,
                        String imagen,
                        String nombre,
                        int edad,
                        float peso,
                        String historia) {
        this.idPersonaje = idPersonaje;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }

    public PersonajeDto() {
    }


}
