package com.example.pelisDisney.repository;

import com.example.pelisDisney.model.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {

    @Query(value = "SELECT * FROM PELICULA peli WHERE LOWER(peli.TITULO) = LOWER(?1)",nativeQuery = true)
    Optional<List<Pelicula>>findByTitulo(String titulo);

    @Query(value = "SELECT * FROM PELICULA peli WHERE peli.ID_PELICULA = ?1",nativeQuery = true)
    Optional<List<Pelicula>>findByIdPelicula(Long idPelicula);

    @Query(value =  "SELECT * FROM PELICULA peli WHERE peli.ID_PELICULA = ?1 and LOWER(peli.TITULO) = LOWER(?2)"
            ,nativeQuery = true)
    Optional<List<Pelicula>> findByIdPeliculaAndTitulo(Long idPelicula,String titulo);

}
