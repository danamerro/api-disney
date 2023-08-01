package com.example.pelisDisney.repository;

import com.example.pelisDisney.model.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero,Long> {

    @Query(value = "SELECT * FROM GENERO genero WHERE LOWER(genero.NOMBRE) = LOWER(?1)",nativeQuery = true)
    Optional<List<Genero>>findByNombre(String nombre);

    @Query(value = "SELECT * FROM GENERO genero WHERE genero.ID_GENERO = ?1",nativeQuery = true)
    Optional<List<Genero>>findByIdGenero(Long idGenero);

    @Query(value = "SELECT * FROM GENERO genero WHERE genero.ID_GENERO = ?1 and LOWER(genero.NOMBRE) =  LOWER(?2)"
            ,nativeQuery = true)
    Optional<List<Genero>> findByIdGeneroAndNombre(Long idGenero,String nombre);

}
