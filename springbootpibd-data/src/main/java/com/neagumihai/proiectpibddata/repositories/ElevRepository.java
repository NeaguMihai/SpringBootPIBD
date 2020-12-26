package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Elev;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElevRepository extends CrudRepository<Elev, Integer> {

    @Query(value = "SELECT * FROM elev LIMIT ?1, ?2", nativeQuery = true)
    List<Elev> getAllByLimit(Integer offset, Integer limit);
}
