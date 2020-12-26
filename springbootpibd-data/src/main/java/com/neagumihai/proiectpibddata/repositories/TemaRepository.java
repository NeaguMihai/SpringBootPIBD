package com.neagumihai.proiectpibddata.repositories;


import com.neagumihai.proiectpibddata.model.Tema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TemaRepository extends CrudRepository<Tema, Integer> {

    @Query(value = "SELECT * FROM tema LIMIT ?1, ?2", nativeQuery = true)
    List<Tema> getAllByLimit(Integer offset, Integer limit);
}
