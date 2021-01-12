package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.Elev;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElevRepository extends JpaRepository<Elev, Integer> {

    @Query(value = "SELECT e FROM Elev e")
    Page<Elev> getAllByLimit(Pageable pageable);
}
