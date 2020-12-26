package com.neagumihai.proiectpibddata.service;

import com.neagumihai.proiectpibddata.model.ElevTema;

import java.util.List;
import java.util.Optional;

public interface ElevTemaService {

    boolean saveTema(ElevTema elevTema);

    List<ElevTema> getAll(Integer offset, Integer limit);

    void deleteElevTema(ElevTema elevTema);

    ElevTema updateElevTema(ElevTema elevTema);

    List<ElevTema> getByIdElev(Integer id);
}
