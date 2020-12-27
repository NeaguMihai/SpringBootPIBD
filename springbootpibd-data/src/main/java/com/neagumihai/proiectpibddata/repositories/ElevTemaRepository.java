package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.ElevTemaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElevTemaRepository extends JpaRepository<ElevTema, ElevTemaId> {

    @Query(value = "SELECT * FROM elev_tema WHERE id_elev = ?1 AND id_tema = ?2", nativeQuery = true)
    Optional<ElevTema> findAllByIdElevAndIdTema(Integer id1, Integer id2);

    @Query(value = "SELECT * FROM elev_tema WHERE id_elev = ?1", nativeQuery = true)
    List<ElevTema> findByIdElev(Integer id1);

    @Query(value = "SELECT * FROM elev_tema LIMIT ?1, ?2", nativeQuery = true)
    List<ElevTema> getAll(Integer offset, Integer limit);

}
