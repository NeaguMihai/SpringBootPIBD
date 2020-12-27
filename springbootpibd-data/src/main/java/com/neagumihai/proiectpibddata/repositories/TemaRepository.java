package com.neagumihai.proiectpibddata.repositories;


import com.neagumihai.proiectpibddata.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {

    @Query(value = "SELECT * FROM tema LIMIT ?1, ?2", nativeQuery = true)
    List<Tema> getAllByLimit(Integer offset, Integer limit);


}
