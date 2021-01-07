package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.ElevTema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ElevTemaService {

    boolean saveTema(ElevTema elevTema);

    Page<ElevTema> getAll(Pageable pageable);

    void deleteElevTema(ElevTema elevTema);

    ElevTema updateElevTema(ElevTema elevTema);

    List<ElevTema> getByIdElev(Integer id);

    List<ElevTema> getByIdTema(Integer id);

    List<Integer> getAllIdsTeme(Integer id);

    Optional<ElevTema> findByIdElevAndIdTema(Integer idElev, Integer idTema);
}
