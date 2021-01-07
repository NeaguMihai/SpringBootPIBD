package com.neagumihai.proiectpibddata.repositories;


import com.neagumihai.proiectpibddata.model.Tema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {

    @Query(value = "SELECT t FROM Tema t")
    Page<Tema> getAllByLimit(Pageable pageable);

    @Query(value = "SELECT t FROM Tema t WHERE t.id NOT IN (:ids) ")
    Page<Tema> getAllByLimitAndId(@Param("ids") List<Integer> ids, Pageable pageable);

}
