package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.ElevTemaId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ElevTemaRepository extends CrudRepository<ElevTema, ElevTemaId> {

    Optional<ElevTema> findAllByIdElevAndIdTema(Integer id1, Integer id2);

    List<ElevTema> findByIdElev(Integer id1);

    @Query(value = "SELECT * FROM elev_tema LIMIT ?1, ?2", nativeQuery = true)
    List<ElevTema> getAll(Integer offset, Integer limit);
}
