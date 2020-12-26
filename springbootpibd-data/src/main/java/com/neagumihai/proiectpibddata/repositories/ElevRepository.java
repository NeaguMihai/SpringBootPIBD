package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Elev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ElevRepository extends JpaRepository<Elev, Integer> {

    @Query(value = "SELECT * FROM elev LIMIT ?1, ?2", nativeQuery = true)
    List<Elev> getAllByLimit(Integer offset, Integer limit);
}
