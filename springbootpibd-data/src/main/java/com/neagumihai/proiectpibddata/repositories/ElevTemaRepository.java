package com.neagumihai.proiectpibddata.repositories;

import com.neagumihai.proiectpibddata.model.ElevTema;
import com.neagumihai.proiectpibddata.model.ElevTemaId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ElevTemaRepository extends JpaRepository<ElevTema, ElevTemaId> {

    @Transactional
    @Query(value = "SELECT et FROM ElevTema et WHERE et.idElev = :idEl AND et.idTema = :idTe")
    Optional<ElevTema> findAllByIdElevAndIdTema(@Param("idEl") Integer id1,@Param("idTe") Integer id2);

    @Transactional
    @Query(value = "SELECT et FROM ElevTema et WHERE et.idElev = :id")
    List<ElevTema> findByIdElev(@Param("id") Integer id1);

    @Transactional
    @Query(value = "SELECT et FROM ElevTema et WHERE et.idTema = :id")
    List<ElevTema> findByIdTema(@Param("id") Integer id1);

    @Transactional
    @Query(value = "SELECT et FROM ElevTema et")
    Page<ElevTema> getAll(Pageable pageable);

    @Transactional
    @Query(value = "SELECT et.idTema FROM ElevTema et WHERE et.idElev = :id")
    List<Integer> getAllIdTeme(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ElevTema et SET et.link_tema = :lt WHERE et.idElev = :ie AND et.idTema = :it" )
    Integer update(@Param("lt") String link,@Param("ie") Integer idElev,@Param("it") Integer idTema);

}
