package com.example.pelisDisney.repository;

import com.example.pelisDisney.model.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//se usa jpa porque esa libreria ya contiene el crud, si hay que hacer mas especifico se
//rellena en las clases ej findbyNombreUsuarioEspecifico.
public interface PersonajeRepository extends JpaRepository<Personaje,Long> {
    @Query(value = "SELECT * FROM PERSONAJE p WHERE LOWER(p.NOMBRE) = LOWER(?1)",nativeQuery = true)
    Optional<List<Personaje>> findByNombre(String nombre);

    @Query(value = "SELECT * FROM PERSONAJE p WHERE p.ID_PERSONAJE = ?1",nativeQuery = true)
    Optional<List<Personaje>> findByIdPersonaje(Long idPersonaje);

    @Query(value = "SELECT * FROM PERSONAJE p WHERE p.ID_PERSONAJE = ?1  and  LOWER(p.NOMBRE) = LOWER(?2)"
            , nativeQuery = true)
    Optional<List<Personaje>> findByIdPersonajeAndNombre(Long IdPersonaje, String nombre);

}
